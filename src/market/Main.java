package market;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		UserPortfolio p1 = new UserPortfolio();

		Scanner scanner = new Scanner(System.in);
		int selection;

		do {
			System.out.println("\n=======Welcome to the stock market!========\n");

			System.out.println("\n1- Buy a stock" + "\n2- Sell a stock"
					+ "\n3- View a list of the stocks and their prices" + "\n4- Add balance to my account account"
					+ "\n5- Print my current portfolio" + "\n6- Print my current assets" + "\n7- Quit menu"
					+ "\n\nWhat would you like to do today?");

			selection = scanner.nextInt();
			scanner.nextLine();
			
			
			switch (selection) {
 
			case 1: { // buy stock
				System.out.println("Please enter the stock symbol you want to buy: ");
				String stockSymbol = scanner.nextLine();
				p1.buyStock(stockSymbol);
				break;
			} // end of selection1

			case 2: { // sell stock
				System.out.println("Please enter the stock symbol you want to sell: ");
				String stockSymbol = scanner.nextLine();
				p1.sellStock(stockSymbol);
				break;
			} // end of selection2

			case 3:{ // view stocks
				Market.printMarket();
				break;
			}

			case 4:{ // add money
				System.out.println("Please enter the amount you want to reload: ");
				int amount = scanner.nextInt();
				p1.acc.addBalance(amount);
				System.out.println("You have reloaded $" + amount + " to your account!\n" 
				+ "Your current balance is $" + p1.acc.getBalance() + "!\n");
				break;
			}

			case 5:{ // print portfolio
				p1.printMarket();
				break;
			}

			case 6:{ // print current assets
				System.out.println("Your current assets is $" + p1.acc.getBalance() + "!\n");
				break;
			}
				
				
			}
			
			Market.randomWalk();

		} // end of do loop
		while (selection != 7);
		System.out.println("Goodbye..");
		scanner.close();
	}// end of main
}// end of class
