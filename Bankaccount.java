import java.util.Scanner;
 class Bankaccount
{
private double balance;
public Bankaccount(double initBalance)
{
this.balance=initBalance;
}
public double getbalance()
{
return balance;

}
public void deposite(double amount)
{
if (amount>0)
{
balance += amount;
}
}
public boolean withdraw(double amount)
{
if(balance >=amount)
{
balance -= amount;
return true;
}
else
{
return false;
}
}
}

 class ATM
{
 private Bankaccount account;
 private Scanner input;
 public ATM(Bankaccount account)
 {
  this.account=account;
 }
public void displaymenu()
{
  System.out.println("welcome to ATM.");
  System.out.println("1. Check Balance");
  System.out.println("2. deposite");
  System.out.println("3. withdraw");
  System.out.println("4. exit");
}
public void CheckBalance()
 {
   System.out.printf("your  balance: $%.2f %n",account.getbalance());
 }
public void deposite(double amount)
   {
     account.deposite(amount);
     System.out.printf("$%.2f has been deposited successfully.%n",amount);
   }
public void withdraw(double amount)
  {
   if (account.withdraw(amount))
  {
    System.out.printf("$%.2f has  been withdraw successfully from account.%n",amount);
  }
   else
  {

   System.out.println("insuffiicient amount to withdraw ");
  }
 }
public static void main(String[] args)
{
 Scanner input =new Scanner(System.in);
 Bankaccount account= new Bankaccount(1000);
 ATM atm =new ATM(account);
 while(true)
{
atm.displaymenu();
System.out.println("please choose an option:");
int choice = input.nextInt();
 switch (choice)
{
   case 1:
     atm.CheckBalance();
     break;
   case 2:
     System.out.print("enter the deposite amount:");
     double depositeamount = input.nextDouble();
     atm.deposite(depositeamount);
     break;
   case 3:
     System.out.print("enter withdraw amount:");
     double withdrawamount = input.nextDouble();
     atm.withdraw(withdrawamount);
     break;
   case 4:
     System.out.println("Thankyou for using atm.");
     input.close();
     System.exit(0);
   default:
     System.out.println("invalid option.");
      }
     }
    }
   }     

      




