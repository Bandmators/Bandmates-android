#include <jni.h>
#include "include/AudioProcessor.h"
#include <syslog.h>

using namespace std;

extern "C"
{
JNIEXPORT jintArray
JNICALL
Java_com_dygames_bandmates_feed_view_FeedActivity_getAudioPCM(JNIEnv *env, jobject thiz,
                                                              jstring path) {
    const char *audio_path = env->GetStringUTFChars(path, 0);

    AudioProcessor *audioProcessor = new AudioProcessor();

    syslog(0, "%s", audio_path);
    vector <int16_t> audioPCM = audioProcessor->getAudioPCM(audio_path);
    jintArray result = env->NewIntArray(audioPCM.size());
    size_t audioPCMSize = audioPCM.size();
    if (result == nullptr) return result;


    jint *jIntArray = new jint[audioPCMSize];
    for (size_t i = 0; i < audioPCMSize; ++i) {
        jIntArray[i] = static_cast<jint>(audioPCM[i]);
    }
    env->SetIntArrayRegion(result, 0, audioPCM.size(), jIntArray);
    delete[] jIntArray;
    env->ReleaseStringUTFChars(path, audio_path);
    return result;
}
}
