
public class Operation {
	private boolean valid = true;
	private String errorMessage = "";
	private double answer;
	private char operator;
	private double operand1;
	private double operand2;

	public Operation(char operator, double operand1, double operand2) {
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
		operate();
	}

	public static char[] getAllOperators() {
		return new char[] { '+', '-', '*', '/' };
	}

	private void operate() {

		switch (operator) {
			case '+': {
				this.answer = Add.operate(operand1, operand2);
				break;
			}
			case '-': {
				this.answer = Subtract.operate(operand1, operand2);
				break;
			}
			case '*': {
				this.answer = Multiply.operate(operand1, operand2);
				break;
			}
			case '/': {
				if (!Divide.validateDivide(operand1, operand2)) {
					this.valid = false;
					this.errorMessage = "Error: Divide by zero";
					break;
				} else {
					this.answer = Divide.operate(operand1, operand2);
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
