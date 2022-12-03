package UseCase;

import ViewModel.searchViewModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SearchTest {

    @Test
    public void testExactSearch(){
        searchViewModel searchViewModel = new searchViewModel();
        searchViewModel.search("Food");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].substring(0, outputSong[1].length()-2).equals("Food")) {
                count++;
            }
        }
        Assertions.assertEquals(1, count);
    }

    @Test
    public void testSearch(){
        searchViewModel searchViewModel = new searchViewModel();
        searchViewModel.search("foo");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].toLowerCase().contains("foo")) {
                count++;
            }
        }
        Assertions.assertEquals(3, count);
    }

    @Test
    public void testEmptySearch(){
        searchViewModel searchViewModel = new searchViewModel();
        searchViewModel.search("");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] ignored : outputSongs) {
            count++;
        }
        Assertions.assertEquals(outputSongs.length, count);
    }

    @Test
    public void testNotInDatabaseSearch(){
        searchViewModel searchViewModel = new searchViewModel();
        searchViewModel.search("abc");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].toLowerCase().contains("abc")) {
                count++;
            }
        }
        Assertions.assertEquals(0, count);
    }
}
