
import java.util.HashMap;
import java.util.Scanner;


class Account{
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	// CONSTRUCTOR
	public Account(String accountNumber,String accountHolderName) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = 0.0;
	}
	
	// Method to deposit money
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposit successful! New Balance: " + balance);
		}else {
			System.out.println("Invalid deposit amount.");
		}
	}
	
	// Method to Withdraw money
	
	public void withdraw(double amount) {
		if(0 < amount && amount <= balance) {
			balance -= amount;
			System.out.println("Withdraw successful! After Withdraw: " + balance);
		}else {
			System.out.println("Insufficiennt balance or invalid withdraw amount");
		}
	}
	
	// Method to check balance
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
}

// Class representing the bank which manages multiple accounts
public class Bank {
	private HashMap<String,Account> accounts = new HashMap<>();
	
	// Method to create a new account
	public void createAccount(String accountNumber, String accountHolderName) {
		if(!accounts.containsKey(accountNumber)) {
			Account account = new Account(accountNumber,accountHolderName);
			
			accounts.put(accountNumber, account);
			
			System.out.println("Account created successfully!");
		}else {
			System.out.println("Account with thiis number already exists.");
		}
	}
	
	// Method to access an existing account
	public Account getAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n--- Simple Banking Application ---");
			
			System.out.println("1. Create Account");
			
			System.out.println("2. Deposit Money");
			
			System.out.println("3. Withdraw Money");
			
			System.out.println("4. Check Balance");
			
			System.out.println("5. Exit");
			
			System.out.println("Choose an option: ");
				int choice = sc.nextInt();
				
				sc.nextLine();   //Consume newline
				
				switch(choice) {
				case 1:
					System.out.print("Enter Account Number: ");
					String accountNumber = sc.nextLine();
					
					System.out.print("Enter Account Holder Name: ");
					String accountHolderName = sc.nextLine();
					bank.createAccount(accountNumber, accountHolderName);
							break;
				case 2:
					System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();
                    Account account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Current balance: " + account.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the banking application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
				}
		}	
	}
}
