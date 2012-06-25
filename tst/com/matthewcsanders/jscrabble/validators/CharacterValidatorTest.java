package com.matthewcsanders.jscrabble.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

import com.matthewcsanders.jscrabble.validators.CharacterValidator;

public class CharacterValidatorTest {
	@Test
	public void shouldCreateCharacterValidator() {
		assertNotNull(getVal());
	}
	
	@Test
	public void shouldValidate() {
		Set<String> result = getVal().getValid("..o",null);
		assertEquals(2, result.size());
	}
	
	@Test
	public void shouldValidateSingle() {
		Set<String> result = getVal().getValid("..h...", null);
		assertEquals(1, result.size());
	}
	
	@Test
	public void shouldReturnNone() {
		Set<String> result = getVal().getValid("...f..", null);
		assertEquals(0, result.size());
	}
	
	public CharacterValidator getVal() {
		return new CharacterValidator(Arrays.asList("one", "two", "three"));
	}
}