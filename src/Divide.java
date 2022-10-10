
public class Divide {
	public static boolean validateDivide(double operand1, double operand2) {
		if (operand2 == (double) 0) {
			return false;
		}
		return true;
	}

	public static double operate(double operand1, double operand2) {
		return operand1 / operand2;
	}

}
