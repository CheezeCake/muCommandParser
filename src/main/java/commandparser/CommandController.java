package commandparser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController
{
	@RequestMapping(value = "/parse_command", method = { RequestMethod.GET, RequestMethod.POST })
	public Object parseCommand(@RequestParam(value="command", defaultValue="") String command)
	{
		command = command.toLowerCase();
		System.out.println(command);

		try {
			final int LIST = 0;
			final int SEARCH = 1;

			final String[] commands = {
				"list",
				"search"
			};

			final Pattern[] patterns = {
				Pattern.compile("^lister?( (chansons?|musiques?)?)?$"),
				Pattern.compile("^rechercher?( (artiste|titre)?)?(.*)$")
			};

			for (int i = 0; i < patterns.length; i++) {
				Matcher m = patterns[i].matcher(command);
				if (m.find()) {
					switch (i) {
						case LIST:
							return new Command(commands[LIST]);
						case SEARCH:
							return new Search(commands[SEARCH],
									(m.group(2) != null) ? m.group(2) : "everything",
									(m.group(3) != null) ? m.group(3) : "");
					}
				}
			}
		}
		catch (Exception e)
		{}

		return new Error("Could not parse command");
	}
}
