package jscrabble.validators;

import java.util.Set;

import jscrabble.Tray;


public interface Validator {
	public Set<String> getValid(String line, Tray tray);
}