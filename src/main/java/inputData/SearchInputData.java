package inputData;

/**
 * Application Business Rules layer data structure for submitting search input to use cases.
 */
public class SearchInputData {
    private final String searchText;

    /**
     * @param text String search query
     */
   public SearchInputData(String text){
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
