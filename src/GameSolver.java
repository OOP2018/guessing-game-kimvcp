import java.util.Random;
import java.util.Scanner;

/**
 * Automatically find the secret to any NumberGame.
 * 
 * @author Vichaphol Thamsuthikul
 * @version 2018.01.17
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution. The NumberGame object must provide
	 * messages (getMessage) containing the phrase "too small" if a guess is too
	 * small and "too large" if a guess is too large, for efficient solution.
	 * 
	 * @param game
	 *            is the NumberGame to solve
	 * @return the secret value
	 */
	public int play(NumberGame game) {
		Random random = new Random();
		int max = game.getUpperBound();
		int min = 1;
		int guess = (max - min) / 2;
		while (true) {
			boolean correct = game.guess(guess);
			if (correct)
				return guess;
			if (game.getMessage().contains("large")) {
				max = guess;
				guess -= (max - min) / 2;
			} else if (game.getMessage().contains("small")) {
				min = guess;
				guess += (max - min) / 2;
			}

		}
	}
}
