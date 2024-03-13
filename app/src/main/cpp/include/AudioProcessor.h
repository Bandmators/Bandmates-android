#include <iostream>
#include <vector>

using namespace std;

class AudioProcessor
{
public:
    vector<int16_t> getAudioPCM(const char *audio_file);
};
