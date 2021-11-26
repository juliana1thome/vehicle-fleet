package bus;

public class Validator{
	/**
	 * Validate if text is empty
	 * 
	 * @param text Text inserting for validation
	 */
	public static void validateValueEmpty(String text) throws EmptyFieldException {
		if (text.isEmpty()) {
			throw new EmptyFieldException();
		}
	}

	/**
	 * Validate if number is negative or equal zero
	 * 
	 * @param	number:	Number of type Integer inserted for validation
	 * */
	public static void validateNegativeNumber(Integer number) throws NegativeNumberException {
		if (number <= 0) {
			throw new NegativeNumberException();
		}
	}
	
	/**
	 * Validate if number is negative or equal zero
	 * 
	 * @param	number:	Number of type Double inserted for validation
	 * */
	public static void validateNegativeNumber(Double number) throws NegativeNumberException {
		if (number <= 0) {
			throw new NegativeNumberException();
		}
	}
	
	/**
	 * Validate if number is negative or equal zero
	 * 
	 * @param	number:	Number of type Short inserted for validation
	 * */
	public static void validateNegativeNumber(Short number) throws NegativeNumberException {
		if (number <= 0) {
			throw new NegativeNumberException();
		}
	}	
}
