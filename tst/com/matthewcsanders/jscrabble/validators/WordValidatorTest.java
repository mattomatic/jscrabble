package com.matthewcsanders.jscrabble.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Set;

import jscrabble.validators.WordValidator;

import org.junit.Test;



public class WordValidatorTest {
	@Test
	public void shouldCreateWordValidator() {
		assertNotNull(getVal());
	}
	
	@Test
	public void shouldEliminateWord() {
		WordValidator val = getVal();
		
		Set<String> cur = val.getValid(".n.", null);
		
		assertEquals(1, cur.size());
		assertEquals("one", cur.iterator().next());
	}
	
	private WordValidator getVal() {
		return new WordValidator(Arrays.asList("one", "two", "three"));
	}
}