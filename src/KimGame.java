import java.util.Random;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

/**
 * Example guessing game.
 * 
 * @author Vichaphol Thamsuthikul
 * @version 2018.01.11
 */
public class KimGame extends NumberGame {
	/** upper bound for secret number */
	private int upperBound;
	/** the solution to the game */
	private int secret;

	public KimGame(int upperbound) {
		this.upperBound = upperbound;
		long seed = System.nanoTime();
		Random randomNumber = new Random(seed);
		this.secret = randomNumber.nextInt(upperbound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + upperbound);
	}

	/**
	 * Evaluate a user's guess.
	 * 
	 * @param number
	 *            is the user's guess
	 * @return true if guess is correct, false otherwise
	 */
	public boolean guess(int number) {
		if (number == secret) {
			setMessage("Correct! The number is " + secret);
			return true;
		} else if (number < secret) {
			setMessage("Your answer is too small.");
		} else
			setMessage("Your answer is too large.");
		return false;
	}

	/** Get the game upper bound. */
	public int getUpperBound() {
		if (upperBound > 0)
			return upperBound;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Guess a number between 1 and " + upperBound;
	}
}
