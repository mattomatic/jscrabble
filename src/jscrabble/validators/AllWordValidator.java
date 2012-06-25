package jscrabble.validators;

import java.util.HashSet;
import java.util.Set;

import jscrabble.Tray;


public class AllWordValidator implements Validator 
{
	private Set<String> valid = new HashSet<String>();

	public AllWordValidator(Iterable<String> strings) 
	{
		for (String str : strings) 
		{
			valid.add(str);
		}
	}

	@Override
	public Set<String> getValid(String line, Tray tray) {
		return valid;
	}
}