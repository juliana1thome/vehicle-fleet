package bus;

public class EmptyFieldException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String message = "Raise exception... Empty field exception...";

	public EmptyFieldException() {
		super(message);
	}

	public EmptyFieldException(String newMessage) {
		super(newMessage);
	}

}
