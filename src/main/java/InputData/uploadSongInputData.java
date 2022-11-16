package InputData;

public class uploadSongInputData {
    String filepath;
    String uploader;
    public uploadSongInputData(String filepath, String uploader){
        this.filepath = filepath;
        this.uploader = uploader;
    }

    public String getFilepath(){
        return this.filepath;
    }

    public String getUploader(){
        return this.uploader;
    }
}