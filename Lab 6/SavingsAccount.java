
public class SavingsAccount extends BankAccount {
	
	private double rate=0.025;
	private int savingsNumber=0;
	private String accountNumber;
	
	
	
	public SavingsAccount(String name, double amount)
	{
		super(name,amount);
		this.accountNumber=super.getAccountNumber() + "-" + savingsNumber;
		
		
	}
	
	public void postInterest()
	{
		double interest;
		
		interest=(getBalance() * rate) / 12;
		deposit(interest);
	}
	
	@Override
	public String getAccountNumber ()
	{
		return accountNumber;
	}
	
	//copy constructor
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		
		super(oldAccount.getOwner(), amount); 
	//	this.savingsNumber = oldAccount.savingsNumber + 1;
		savingsNumber++;
		accountNumber =  oldAccount.getAccountNumber() + this.savingsNumber;
	}
	
}

