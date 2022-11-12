package OutputData;

public class newPlaylistOutputData {
    String playlistCreated;
    public newPlaylistOutputData(String success){
        this.playlistCreated = success;
    }

    public String getCreatedMessage(){
        return this.playlistCreated;
    }
}
