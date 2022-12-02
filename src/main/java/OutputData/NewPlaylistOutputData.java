package OutputData;
/**
 * Application Business Rules layer data structure for receiving new playlist output from use cases.
 */
public class NewPlaylistOutputData {
    String playlistCreated;

    /**
     * @param success whether creation of playlist was successful
     */
    public NewPlaylistOutputData(String success){
        this.playlistCreated = success;
    }

    /**
     * @return the message to return to the view after creation of playlist
     */
    public String getCreatedMessage(){
        return this.playlistCreated;
    }
}
