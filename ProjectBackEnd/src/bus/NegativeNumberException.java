package bus;

public class NegativeNumberException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String message = "Raise the exception....Negative number exception";
	
	public NegativeNumberException() {
		super(message);
	}
	
	public NegativeNumberException(String newMessage) {
		super(newMessage);
	}
}
