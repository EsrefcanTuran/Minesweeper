import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int r, c;
	    System.out.println("Welcome to the Minesweeper Game!\nHow many rows?: ");
	    r = input.nextInt();
	    System.out.println("How many columns?: ");
	    c = input.nextInt();
	    Minesweeper mine = new Minesweeper(r, c);
	    mine.run();

	}

}
