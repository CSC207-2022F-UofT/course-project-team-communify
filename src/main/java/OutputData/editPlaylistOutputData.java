package OutputData;

public class editPlaylistOutputData {
    private String editConfirmation;
    public editPlaylistOutputData(String editConfirmation){
        this.editConfirmation = editConfirmation;
    }
    public String getPlaylistEditedConfirmation(){
        return this.editConfirmation;
    }

}
