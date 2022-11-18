package InputData;

/**
 * Application Business Rules layer data structure for submitting song input to use cases.
 */
public class uploadSongInputData {
    String filepath;

    /**
     * @param filepath the path to the Song file to be uploaded
     */
    uploadSongInputData(String filepath){
        this.filepath = filepath;
    }
}