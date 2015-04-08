package commandparser;

public class Command
{
	private String type = "";
	private String argument = "";

	public Command(String type, String argument)
	{
		this.type = type;
		this.argument = argument;
	}

	public Command(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	public String getArgument()
	{
		return argument;
	}
}
