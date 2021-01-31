package com.tasif;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string : ");
		String expression = scanner.next();
		String[] splitednumbers = calculator.splitExpression(expression);
		calculator.validateNumber(splitednumbers);
		if (calculator.validateNumber(splitednumbers)) {
			int[] numbers = calculator.numericConvert(splitednumbers);
			int sum = calculator.add(numbers);
			System.out.print("Sum : " + sum);
		}
		scanner.close();
	}

	public int add(int[] numbers) {
		int sum = 0;
		for (int x : numbers) {
			sum = sum + x;
		}
		return sum;
	}

	public String[] splitExpression(String expression) {
		String[] splitedNumbers = expression.split(",");
		return splitedNumbers;
	}

	public boolean validateNumber(String[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i].isEmpty() || numbers[i] == null) {
				throw new RuntimeException();
			}
		}
		return true;
	}

	public int[] numericConvert(String[] numbers) {
		int[] result = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			try {
				result[i] = Integer.parseInt(numbers[i]);
			} catch (RuntimeException e) {
				return null;
			}
		}
		return result;
	}
}
