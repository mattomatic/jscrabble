package com.matthewcsanders.jscrabble.validators;

import java.util.Set;

import com.matthewcsanders.jscrabble.Tray;


public interface Validator {
	public Set<String> getValid(String line, Tray tray);
}