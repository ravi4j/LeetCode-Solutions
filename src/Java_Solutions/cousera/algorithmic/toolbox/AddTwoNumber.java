package cousera.algorithmic.toolbox;

import java.util.Scanner;

public class AddTwoNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		AddTwoNumber addTwoNumber = new AddTwoNumber();
		System.out.println(addTwoNumber.add(x, y));
	}

	public int add( int x , int y){
		return x + y;
	}
}
