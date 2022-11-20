package OutputData;
public class NewPlaylistOutputData {
    String playlistCreated;
    public NewPlaylistOutputData(String success){
        this.playlistCreated = success;
    }

    public String getCreatedMessage(){
        return this.playlistCreated;
    }
}
