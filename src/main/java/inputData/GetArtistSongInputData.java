package inputData;
/**
 * Application Business Rules layer data structure for submitting artist song input to use cases.
 */
public class GetArtistSongInputData {

    final String username;

    /**
     * @param username the username of the artist
     */
    public GetArtistSongInputData(String username){
        this.username = username;
    }

    /**
     * @return the username of the artist
     */
    public String getUsername(){
        return this.username;
    }
}
