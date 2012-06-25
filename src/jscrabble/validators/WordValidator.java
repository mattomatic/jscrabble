package jscrabble.validators;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jscrabble.Tray;


public class WordValidator implements Validator {
	private Map<Integer, Map<Character, Set<String>>> valid = new HashMap<Integer, Map<Character, Set<String>>>();

	public WordValidator(Iterable<String> strings) {
		for (String str : strings) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				Map<Character, Set<String>> chars = valid.get(i);
				if (chars == null) {
					chars = new HashMap<Character, Set<String>>();
					valid.put(i, chars);
				}
				Set<String> words = chars.get(c);
				if (words == null) {
					words = new HashSet<String>();
					chars.put(c, words);
				}
				words.add(str);
			}
		}
	}

	private Set<String> getValid(int loc, char c) {
		Map<Character, Set<String>> chars = valid.get(loc);
		Set<String> result = new HashSet<String>();
		if (chars != null) {
			Set<String> valid = chars.get(c);
			if (valid != null) {
				result = valid;
			}
		}

		return result;
	}

	public Set<String> getValid(String line, Tray tray) {
		Set<String> result = new HashSet<String>();

		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c != '.') {
				Set<String> cur = getValid(i, c);
				if (result.isEmpty()) {
					result = cur;
				} else {
					result = intersect(cur, result);
				}
			}
		}

		return result;
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