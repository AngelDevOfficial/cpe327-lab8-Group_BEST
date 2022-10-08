import java.util.Scanner;

public class Calculator {

	static double operand1, operand2;
	static char operator;
	static Scanner input = new Scanner(System.in);

	public static double getOperand1() {
		System.out.print("Insert OPERAND 1 >> ");
		String textInput = input.next();
		try {
			return Double.parseDouble(textInput);
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid Operand");
			return getOperand1();
		}
	}

	public static char getOperator() {
		System.out.print("Insert OPERATOR >> ");
		char[] operators = Operation.getAllOperators();
		String textInput = input.next();
		if (textInput.length() > 1) {
			System.out.println("Error: Invalid Operator");
			return getOperator();
		}
		for (char c : operators) {
			if (c == textInput.charAt(0)) {
				return c;
			}
		}
		System.out.println("Error: Invalid Operator");
		return getOperator();
	}

	public static double getOperand2() {
		System.out.print("Insert OPERAND 2 >> ");
		String textInput = input.next();
		try {
			return Double.parseDouble(textInput);
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid Operand");
			return getOperand2();
		}
	}

	public static void main(String[] args) {

		operand1 = getOperand1();
		operator = getOperator();
		operand2 = getOperand2();
		System.out.printf("\nEnter: %g %c %g\n", operand1, operator, operand2);

		Operation response = new Operation(operator, operand1, operand2);

		if (response.isValid()) {
			System.out.printf("Answer: %g\n", response.getAnswer());
		} else {
			System.out.println(response.getErrorMessage());
		}
	}

}
