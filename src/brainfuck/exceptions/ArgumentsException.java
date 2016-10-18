package brainfuck.exceptions;

/**
 * An exception thrown when arguments passed through the bfck executable are not correct.
 *
 * @author Julien Lemaire
 */
public class ArgumentsException extends BrainfuckException {
	/**
	 * The main constructor of the <code>ArgumentsException</code> class.
	 * @param message The message to display as an error.
	 */
	public ArgumentsException(String message) {
		super(message);
	}

	/**
	 * Returns the error code 5 for notifying an error in the command line arguments.
	 * The application will exit with this error code.
	 *
	 * @return 5.
	 */
	@Override
	public int getErrorCode() {
		return 5;
	}
}
