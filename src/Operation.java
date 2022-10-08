
public class Operation {
	private boolean valid = true;
	private String errorMessage = "";
	private double answer;
	private char operator;
	private double number1;
	private double number2;

	public Operation(char operator, double number1, double number2) {
		this.operator = operator;
		this.number1 = number1;
		this.number2 = number2;
		operate();
	}

	public static char[] getAllOperators() {
		return new char[] { '+', '-', '*', '/' };
	}

	private void operate() {

		switch (operator) {
			case '+': {
				this.answer = Add.bro(number1, number2);
				break;
			}
			case '-': {
				this.answer = Subtract.bro(number1, number2);
				break;
			}
			case '*': {
				this.answer = Multiply.bro(number1, number2);
				break;
			}
			case '/': {
				if (!Divide.validateDivide(number1, number2)) {
					this.valid = false;
					this.errorMessage = "Error: Divide by zero";
					break;
				} else {
					this.answer = Divide.bro(number1, number2);
					break;
				}
			}
			default: {
				this.valid = false;
				this.errorMessage = "Error: Invalid Operator";
				break;
			}
		}
	}

	public double getAnswer() {
		return this.answer;
	}

	public boolean isValid() {
		return this.valid;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
