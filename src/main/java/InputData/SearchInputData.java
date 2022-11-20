package InputData;

public class SearchInputData {
    private final String searchText;

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
