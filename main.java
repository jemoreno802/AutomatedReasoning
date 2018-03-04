import java.util.Scanner;

public class main {
	public static void main(String[] argv) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1 to test Part 1 (Model Checking)");
		int answer = scan.nextInt();
		while(answer != 0) {
			System.out.println();
			System.out.println("Testing model checking");
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to test Modus Ponens");
			System.out.println("Enter 2 to test Wumpus World");
			System.out.println("Enter 3 to test Horn Clauses");
			System.out.println("Enter 4 to test Part 2 (Resolution)");
			answer = scan.nextInt();
			
			if(answer == 1) {
				new ModusPonensKB().checkModels();
			}if(answer == 2) {
				new WumpusWorldKB().checkModels();
			}if(answer == 3) {
				new HornClausesKB().checkModels();
			}if(answer == 4) {
				System.out.println("Testing resolution");
				System.out.println("Enter 0 to exit");
				System.out.println("Enter 1 to test Modus Ponens");
				System.out.println("Enter 2 to test Wumpus World");
				System.out.println("Enter 3 to test Horn Clauses");
			}

		}
		System.out.println("Goodbye!");
		
	}
}
