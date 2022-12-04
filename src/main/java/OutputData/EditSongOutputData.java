package outputData;
/**
 * Application Business Rules layer data structure for receiving edited song output from use cases.
 */
public class EditSongOutputData {

    final boolean success;

    /**
     * @param success whether the song was edited
     */
    public EditSongOutputData(boolean success){
        this.success = success;
    }

    /**
     * @return whether the song was edited
     */
    public boolean getSuccess(){
        return this.success;
    }

}
