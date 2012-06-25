package jscrabble.validators;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jscrabble.Tray;


public class CharacterValidator implements Validator {
	Map<Character, Set<String>> valid = new HashMap<Character, Set<String>>();
	
	public CharacterValidator(Iterable<String> strings) {
		for (String str : strings) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				Set<String> cur = valid.get(c);
				if (cur == null) {
					cur = new HashSet<String>();
					valid.put(c, cur);
				}
				cur.add(str);
			}
		}
	}
	
	@Override
	public Set<String> getValid(String line, Tray tray) {
		Set<String> result = Collections.emptySet();
		for (Character c : getChars(line)) {
			Set<String> cur = valid.get(c);
			if (cur == null) {
				result = Collections.emptySet();
				break;
			}else if (result.isEmpty()) {
				result = cur;
			} else {
				result = intersect(result, cur);
			}
		}
		return result;
	}
	
	private static Set<Character> getChars(String line) {
		Set<Character> chars = new HashSet<Character>();
		for (int i = 0 ; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c != '.') {
				chars.add(c);
			}
		}
		return chars;
	}
	
	private static Set<String> intersect(Set<String> one, Set<String> two) {
		Set<String> result = new HashSet<String>();
		
		for (String str : one) {
			if (two.contains(str)) {
				result.add(str);
			}
		}
		
		return result;
	}
}