package OutputData;

public class editPlaylistOutputData {
    private String songAdded;
    private String songRemoved;
    private String nameChanged;
    public editPlaylistOutputData(String songAdded, String songRemoved, String nameChanged){
        this.nameChanged= nameChanged;
        this.songAdded = songAdded;
        this.songRemoved = songRemoved;
    }
    public String getSongAddedConfirmation(){
        return this.songAdded;
    }
    public String getSongRemovedConfirmation(){
        return this.songRemoved;
    }

    public String getNameChangedConfirmation(){
        return this.nameChanged;
    }
}
