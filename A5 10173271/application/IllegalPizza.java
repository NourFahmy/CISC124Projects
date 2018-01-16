package application;

public class IllegalPizza extends Exception {

	private static final long serialVersionUID = -4570706396536287411L;
/*
	 * Provide a relevant error message to the exception's constructor.
	 * @param message A Relevant error message.
	 */
	public IllegalPizza (String message) {
		super(message);
	}

}
