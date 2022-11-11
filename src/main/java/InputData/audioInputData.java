package InputData;

import java.io.File;

/**
 * Add Java docs after
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
