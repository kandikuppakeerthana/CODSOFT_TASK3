import java.util.Scanner;

public class ATMInterface {

    public static void main(String args[])
    {

Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);
        int choice;

        do {
         System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
               } while (choice != 4);

        sc.close();
    
    }
}
class BankAccount{
    double balance;
    BankAccount(double initialBalance){
        balance=initialBalance;
    }
    double getBalance()
    {
        return balance;
    }
    void deposit(double amount)
    {
      balance+=amount;
    }
    void withdraw(double amount)
    {
        balance-=amount;
    }
}
class ATM{
 private BankAccount account;
 ATM(BankAccount account)
 {
    this.account=account;
 }
 void checkBalance()
    {
System.out.println("Available balance:"+account.getBalance());
    }
void deposit(double amount)
{
    if(amount<=0)
    {
        System.out.println("Transaction failed! Invalid deposit amount");
    }
    else{
        account.deposit(amount);
        System.out.println("Successfully deposited "+ amount+"to your account");
    }
}
void withdraw(double amount)
{
    if (amount <= 0) {
            System.out.println("Transaction Failed! Invalid withdrawal amount.");
        } else if (amount > account.getBalance()) {
            System.out.println("Transaction Failed! Insufficient balance.");
        } else {
            account.withdraw(amount);
            System.out.println("Transaction Successful! ₹" + amount + " withdrawn.");
        }
}
 
}

