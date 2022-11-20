package OutputData;

public class EditPlaylistOutputData {
    private String editConfirmation;
    public EditPlaylistOutputData(String editConfirmation){
        this.editConfirmation = editConfirmation;
    }
    public String getPlaylistEditedConfirmation(){
        return this.editConfirmation;
    }

}
