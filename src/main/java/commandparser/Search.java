package commandparser;

public class Search extends Command
{
	private String searchBy = "";

	private String search = "";

	public Search(String searchBy, String search)
	{
		super("search");
		this.searchBy = searchBy;
		this.search = search;
	}

	public String getSearchBy()
	{
		return searchBy;
	}

	public String getSearch()
	{
		return search;
	}
}
