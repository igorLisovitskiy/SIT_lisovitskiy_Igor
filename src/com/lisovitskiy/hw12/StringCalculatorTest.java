package com.lisovitskiy.hw12;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

	@Test
	public void creatingInstanceTest() {
		assertEquals(new StringCalculator().getClass().getName(), "com.lisovitskiy.hw12.StringCalculator");

	}

	@Test
	public void testEmptyString() {
		assertEquals(StringCalculator.add(""), 0);
	}

	@Test
	public void testAdditionOfTwoNumbers() {
		assertEquals(StringCalculator.add(",\n1,2"), 3);
	}
	@Test
	public void testAdditionOfThreeNumbers() {
		assertEquals(StringCalculator.add(",\n1,2,3"), 6);
	}
	@Test
	public void testAdditionOfNumbersOnAfterNewLine() {
		assertEquals(StringCalculator.add(",\n1,2,\n3"), 6);
	}
	@Test
	public void ignoreNumbersLongerThanFourDigitsLength() {
		assertEquals(StringCalculator.add(",\n1,1000,100"), 101);
	}
	@Test
	public void testSemicolonDelimeter() {
		assertEquals(StringCalculator.add(";\n1;100"), 101);
	}
}
