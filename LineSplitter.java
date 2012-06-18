import java.util.*;
import java.util.regex.*;

public class LineSplitter {
	public Iterable<LineGroup> splitLine(String line)
	{
		List<LineGroup> groups = new LinkedList<LineGroup>();
		
		int numGroups = this.getNumGroups(line);
		for (int start = 0; start < numGroups; start++)
		{
			for (int end = 0; end < numGroups; end++)
			{
				if (start > end) continue;
				
				LineGroup group = this.getGroup(line, start, end);
				
				if (start != 0 && group.group.matches("^[.].*"))
				{
					this.shaveLeft(group);
				}
				
				if (end != numGroups - 1 && group.group.matches(".*[.]$"))
				{
					this.shaveRight(group);
				}
				
				groups.add(group);
			}
		}
		
		return groups;
	}
	
	private void shaveLeft(LineGroup group)
	{
		group.lhs = group.lhs + ".";
		group.group = group.group.substring(1);
	}
	
	private void shaveRight(LineGroup group)
	{
		group.rhs = "." + group.rhs;
		group.group = group.group.substring(0, group.group.length() - 1);
	}
	
	private int getNumGroups(String line)
	{
		return line.split("[.]*[^.]+").length - 1;
	}
	
	private LineGroup getGroup(String line, int startIndex, int endIndex)
	{
		String groupRegex = "[.]*[^.]+";
		String regex = "";
		
		for (int i = 0; i < startIndex; i++)
		{
			regex += groupRegex;
		}
		
		regex += "(";
		for (int i = startIndex; i < endIndex + 1; i++)
		{
			regex += groupRegex;
		}
		regex += "[.]*)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		matcher.find();
		
		String lhs = line.substring(0, matcher.start(1));
		String rhs = line.substring(matcher.end(1), line.length());
		String group = matcher.group(1);
		
		return new LineGroup(lhs, group, rhs);
	}
	
	public static void main(String[] args)
	{
		// ...cat...dog...bird ->
		// () (...cat..) (.dog...bird...)
		// () (...cat...dog..) (.bird...)
		// () (...cat...dog...bird...) ()
		// (...cat.) (..dog..) (.bird...)
		// (...cat.) (..dog...bird...) ()
		// (...cat...dog.) (..bird...) ()
		LineSplitter splitter = new LineSplitter();
		
		for(LineGroup lg: splitter.splitLine("...cat...dog...bird..."))
		{
			System.out.println(lg);
		}
	}
	
	
}
