package OutputData;
/**
 * Application Business Rules layer data structure for receiving artist song output from use cases.
 */
public class GetArtistSongOutputData {

    String[][] table;

    /**
     * @param table the 2D array of artist songs
     */
    public GetArtistSongOutputData(String[][] table){
        this.table = table;
    }

    /**
     * @return the 2D array of artist songs
     */
    public String[][] getTable(){
        return this.table;
    }
}
