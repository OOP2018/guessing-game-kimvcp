import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/**
	 * The play method plays using input from a user.
	 * 
	 * @param get
	 *            the NumberGame's game.
	 * @return the guess number.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game);

		// This is just an example.
		while (true) {
			System.out.println(game.getMessage());
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			if (correct)
				return guess;
		}
	}

}
