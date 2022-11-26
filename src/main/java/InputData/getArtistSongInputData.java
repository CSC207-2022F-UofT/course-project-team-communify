package InputData;
/**
 * Application Business Rules layer data structure for submitting artist song input to use cases.
 */
public class getArtistSongInputData {

    String username;

    /**
     * @param username the username of the artist
     */
    public getArtistSongInputData(String username){
        this.username = username;
    }

    /**
     * @return the username of the artist
     */
    public String getUsername(){
        return this.username;
    }
}
