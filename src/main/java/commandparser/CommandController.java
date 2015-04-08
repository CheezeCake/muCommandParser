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
	@RequestMapping(value="/parse_command", method={RequestMethod.GET, RequestMethod.POST})
	public Object parseCommand(@RequestParam(value="command", defaultValue="") String command)
	{
		System.out.println(command);

		try {
			String pattern = "(\\w*) ?(.*)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(command);

			if (m.find()) {
				String[] keywords = { "recherche", "rechercher", "liste", "lister" };
				String keyword = m.group(1);
				String argument = m.group(2);

				System.out.println(keyword + ", " + argument);

				if (Arrays.asList(keywords).contains(keyword))
					return new Command(keyword, m.group(2));
			}
		}
		catch (Exception e)
		{}

		return new Error("Could not parse command");
	}
}
