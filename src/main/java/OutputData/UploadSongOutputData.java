package OutputData;

public class UploadSongOutputData {

    boolean success;

    public UploadSongOutputData(boolean success){
        this.success = success;
    }

    public boolean getSuccess(){
        return this.success;
    }
}
