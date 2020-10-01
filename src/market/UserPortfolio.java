package market;

import java.util.Scanner;

public class UserPortfolio {

	// a list of stock objects
	MarketStock[] stockList;
	int[] shares;		// creates array for particular share amount for each stock symbol
	static int j = 0;	// increments after each specific share bought

	// a bank account
	UserBankAccount acc;
	// stock shares

	Scanner input = new Scanner(System.in);

	// constructor that initialized the list of stocks to be empty (for simplicity
	// sake, made the stock list 20 in length).
	public UserPortfolio() {
		this.stockList = new MarketStock[20];
		this.shares = new int[20];
		this.acc = new UserBankAccount();
	}

	// METHODS
	// reload
	public void reload(double amount) {
		amount = this.input.nextDouble();
		System.out.println("Please enter the amount (in two decimals followed by) you want to reload: ");
		this.acc.addBalance(amount);
	}

	// buy
	public void buyStock(String stockSymbol) {

		int index = 0;
		double value = 0;
		int share = 0;
		boolean flag = true;	

		stockSymbol = stockSymbol.toUpperCase();

		// walk through marketList and find the right stock with stockSymbol

		do {
			for (int i = 0; i < Market.marketList.length; i++) {
				if (stockSymbol.equals(Market.marketList[i].identifier)) {

					// our goal is to use the stockSymbol to get on that stockList index and pull a
					// price out.
					index = i;
					this.stockList[j] = Market.marketList[i];

					// we are going to prompt user for the shares he/she wants to buy
					System.out.print("How many shares would you like to buy for " + stockSymbol + "?\n");
					share = input.nextInt();
					shares[j] = share;
					j++;
					if (acc.balance >= Market.marketList[i].price) {
						System.out.println("You have bought " + share + " stocks from " + stockSymbol + "!");
						flag = false;
						break;	
					}
				}
			}
			if (flag) {
				System.out.println("Invalid stock symbol.");
				flag = false;
			}

		} while (flag);

		value = (double) (share * Market.marketList[index].price);
		this.acc.subBalance(value);
		if (flag == false)
			System.out.println("Your remaining balance is " + acc.getBalance());
	}

	// sell
	public void sellStock(String stockSymbol) {
		// walk through this.stockList and find the right stock with stockSymbol

		int share = 0;
		double value = 0;
		boolean flag = true;

		stockSymbol = stockSymbol.toUpperCase();

		// our goal is to use the stock id to get on that stockList index and pull a
		// price out.
		do {
			for (int i = 0; i < stockList.length; i++) {
				if (stockList[i] == null) {
					break;
				}
				if (stockList[i].identifier.equals(stockSymbol)) {
					System.out.print("How many shares would you like to sell for " + stockSymbol + "?\n");
					share = input.nextInt();
					if (share == shares[i]) {
						value = (double) (share * this.stockList[i].price);
						shares[i] = 0;
						this.stockList[i] = null;
						flag = false;
						break;
					} else if (share < shares[i]) {
						value = (double) (share * this.stockList[i].price);
						shares[i] -= share;
						flag = false;
						break;
					} else {
						System.out.println("Insufficient amount of shares");
					}
				}
			}
			if (flag) {
				System.out.println("Invalid stock symbol.");
				flag = false;
				break;
			}

		} while (flag);

		this.acc.addBalance(value);
		if (flag == false)
			System.out.println("Your remaining balance is " + acc.getBalance());
	}

	// print
	public void printMarket() {
		for (int i = 0; i < stockList.length; i++) {
			if (stockList[i] == null)
				break;
			System.out.print(String.format("%-20s", stockList[i].companyName));
			System.out.print(String.format("%-6s", stockList[i].identifier));
			System.out.print(String.format("%-7.2f", stockList[i].price));
			System.out.println(" - Shares: " + shares[i]);
			System.out.print("\n");
		}

	}

}
