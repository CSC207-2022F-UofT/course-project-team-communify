package OutputData;

/**
 * Application Business Rules layer data structure for receiving newly uploaded song output from use cases.
 */
public class uploadSongOutputData {

    boolean success;

    /**
     * @param success true if and only if the song upload was successful
     */
    public uploadSongOutputData(boolean success){
        this.success = success;
    }

    /**
     * @return true if and only if the song upload was successful
     */
    public boolean getSuccess(){
        return this.success;
    }
}
