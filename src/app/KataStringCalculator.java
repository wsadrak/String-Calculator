package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KataStringCalculator {
	private Scanner input = new Scanner(System.in);
	static boolean correctConversion = false;
	
	public void mainLoop() {
		do {
			String expression = readFromUser();
			int result = calculate(expression);
			printResult(expression, result);
		} while (!correctConversion);
	}
	private String readFromUser() {
		System.out.println("Please type an expression to calculate: ");
		return input.nextLine();
	}

	static int calculate(String expression) {
		int conversionResult = 0;
		try {
			 conversionResult = convert(expression);
			 correctConversion = true;
		} catch (NumberFormatException e) {
			System.err.println("Incorrect data format.");
		}
		return conversionResult;
	}

	private void printResult(String expression, int result) {
		System.out.println("Result of " + expression + " is " + result);
	}

	
	public static int convert(String expression) {
		if (expression == null || expression.length() < 1) {
			return 0;
		}
		List<String> substrings = divideExpressionToSubstrings(expression);
		int result = calculateSumAll(substrings);
		return result;
	}

	private static int calculateSumAll(List<String> substringsFromExpression) {
		int sum = 0;
		for (String singleSubstring : substringsFromExpression) {
			sum += Integer.parseInt(singleSubstring);
		}
		return sum;
	}

	private static List<String> divideExpressionToSubstrings(String expression) {
		String expressionToCalculate = expression.replaceAll(" ", "");
		List<Integer> indexesArray = extractIndexesToCreateSubstrings(expressionToCalculate);

		List<String> substrings = new ArrayList<>();
		for (int i = 0; i < indexesArray.size() - 1; i++) {
			String singleSubstring = expressionToCalculate.substring(indexesArray.get(i), indexesArray.get(i + 1));
			substrings.add(singleSubstring);
		}

		return substrings;
	}

	private static List<Integer> extractIndexesToCreateSubstrings(String expressionToCalculate) {
		List<Integer> indexesArray = new ArrayList<>();
		indexesArray.add(0);
		for (int i = 1; i < expressionToCalculate.length(); i++) {
			if (expressionToCalculate.charAt(i) == '+' || expressionToCalculate.charAt(i) == '-') {
				indexesArray.add(i);
			}
		}
		indexesArray.add(expressionToCalculate.length());
		return indexesArray;
	}

}
