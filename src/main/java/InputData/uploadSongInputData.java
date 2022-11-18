package InputData;

public class uploadSongInputData {
    String filepath;
    String uploader;
    public uploadSongInputData(String filepath, String uploader){
        this.filepath = filepath;
        this.uploader = uploader;
    }
    
    /**
    * @return filepath of the song to be uploaded
    */
    public String getFilepath(){
        return this.filepath;
    }

    /**
    * @return username of the artist who uploaded the song
    */
    public String getUploader(){
        return this.uploader;
    }
}
