package market;

public class UserBankAccount {
	
	//account number
	static int accountNumber = 100;
	int userAccNo;
	//balance
	double balance = 100.00;
	
	UserBankAccount(){
		this.userAccNo = accountNumber + 1;
	}
	
	public int getAccountNumber(){
		
		return accountNumber;
	}
	
	public void setAccountNumber(int userAccNo){
		this.userAccNo = userAccNo;
	}
	
	public double getBalance() {
		return Math.floor(balance * 100) / 100;
	}
	
	public void addBalance(double amount) {			
		this.balance += amount;
		this.getBalance();
	}
	
	public void subBalance(double amount) {
		if(this.balance >= amount) {
			this.balance -= amount;
			this.getBalance();
		}
		else {
			System.out.print( "Insufficient Amount.\n");
		}
	}
	
}
