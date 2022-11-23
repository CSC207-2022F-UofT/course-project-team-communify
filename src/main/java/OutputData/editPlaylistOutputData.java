package OutputData;

/**
 * Application Business Rules layer data structure for receiving playlist output from use cases.
 */
public class editPlaylistOutputData {
    private final String editConfirmation;

    /**
     * @param editConfirmation the message to relay to the view
     */
    public editPlaylistOutputData(String editConfirmation){
        this.editConfirmation = editConfirmation;
    }

    /**
     * @return the message to relay to the view
     */
    public String getPlaylistEditedConfirmation(){
        return this.editConfirmation;
    }

}
