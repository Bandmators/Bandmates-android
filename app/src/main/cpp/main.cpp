#include <jni.h>
#include "include/AudioProcessor.h"
#include <syslog.h>

using namespace std;

extern "C"
{
JNIEXPORT jintArray
JNICALL
Java_com_dygames_bandmates_feed_view_FeedActivity_getAudioPCM(JNIEnv *env, jobject thiz,
                                                              jbyteArray audio_data) {
    AudioProcessor *audioProcessor = new AudioProcessor();
    jboolean isCopy = false;
    jbyte *audio_data_byte_pointer = env->GetByteArrayElements(audio_data, &isCopy);
    size_t audio_size = env->GetArrayLength(audio_data);

    vector<int16_t> audioPCM = audioProcessor->getAudioPCM(
            reinterpret_cast<char *>(audio_data_byte_pointer), audio_size);

    syslog(0, "Audio PCM Size : %d", audioPCM.size());
    jintArray result = env->NewIntArray(audioPCM.size());
    size_t audioPCMSize = audioPCM.size();
    if (result == nullptr) return result;

    jint *jIntArray = new jint[audioPCMSize];
    for (size_t i = 0; i < audioPCMSize; ++i) {
        jIntArray[i] = static_cast<jint>(audioPCM[i]);
    }
    env->SetIntArrayRegion(result, 0, audioPCM.size(), jIntArray);
    delete[] jIntArray;
    return result;
}
}
