package InputData;

import java.io.File;

/**
 * Class that contains and returns an MP3 file for the audio playing use case
 */
public class audioInputData {

    private final File songFile;

    public audioInputData(File songFile) {
        this.songFile = songFile;
    }

    public File getSongFile() {
        return this.songFile;
    }

}
