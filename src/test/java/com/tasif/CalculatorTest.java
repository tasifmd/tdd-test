package com.tasif;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void addTest() {
		Calculator calculator = new Calculator();

		String expression = "10,20,30";
		String[] numbers = calculator.splitExpression(expression);

		boolean expectedValidate = true;
		boolean actualValidate = calculator.validateNumber(numbers);
		assertEquals(expectedValidate, actualValidate);

		int[] actualNumbers = calculator.numericConvert(numbers);
		int expectedSum = 60;
		int actualSum = calculator.add(actualNumbers);
		assertEquals(expectedSum, actualSum);
	}

	@Test(expected = RuntimeException.class)
	public void addTestWithNull() {
		Calculator calculator = new Calculator();
		String expression = "10,20,30," + null;
		String[] numbers = calculator.splitExpression(expression);

		boolean expectedValidate = true;
		boolean actualValidate = calculator.validateNumber(numbers);
		assertEquals(expectedValidate, actualValidate);

		int[] actualNumbers = calculator.numericConvert(numbers);
		int expectedSum = 0;
		int actualSum = calculator.add(actualNumbers);
		assertEquals(expectedSum, actualSum);
	}
}
