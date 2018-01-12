/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new KimGame(upperBound);
		GameSolver ui = new GameSolver();
		int solution = ui.play(game);
		System.out.println("Correct! the answer is " + solution);
		System.out.println("Count: "+game.getCount());
	}
}
