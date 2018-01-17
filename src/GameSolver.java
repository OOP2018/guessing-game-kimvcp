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
		int half = game.getUpperBound()/2;
		int quad = half / 2;
		while (true) {
			System.out.println(game.getMessage());
			System.out.println(half);
			boolean correct = game.guess(half);
			if (correct)
				return half;
			if (game.getMessage().contains("large")) {
				half -= quad;

			} else if (game.getMessage().contains("small")) {
				half += quad;
			}
			if (quad  > 1) {
				quad = quad / 2;
			}
		}

	}
}
