package commandparser;

public class Add extends Command
{
	private String artist = "";

	private String title = "";

	public Add(String artist, String title)
	{
		super("add");
		this.artist = artist;
		this.title = title;
	}

	public String getArtist()
	{
		return artist;
	}

	public String getTitle()
	{
		return title;
	}
}

