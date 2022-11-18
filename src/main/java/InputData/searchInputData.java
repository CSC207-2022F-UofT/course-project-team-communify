package InputData;

/**
 * Application Business Rules layer data structure for submitting search input to use cases.
 */
public class searchInputData {
    private final String searchText;

   public searchInputData(String text){
       this.searchText = text;
   }

    /**
     *
     * @return the value of the searchText instance variable
     */
    public String getSearchText() {
        return this.searchText;
    }
}
