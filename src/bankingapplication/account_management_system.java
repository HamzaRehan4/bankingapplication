package bankingapplication;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat; 

public class account_management_system {
    
   

    public static void main(String[] args) throws ParseException 
    {
        
        
            BankAccount obj1 = new BankAccount();
            obj1.showMenu();
     

    }


}



class BankAccount 
{
    private String CName;
    public void setCName(String Name)
    {
        this.CName = Name;
    }
    public String getCName()
    {
        return this.CName;
    }
    
    private String CAddress;
    public void setCAddress(String Address)
    {
        this.CAddress = Address;
    }
    public String getCAddress()
    {
        return this.CAddress;
    }
    
    private String CPhoneNo;
    public void setCPhoneNo(String PhoneNo)
    {
        this.CPhoneNo = PhoneNo;
    }
    public String getCPhoneNo()
    {
        return this.CPhoneNo;
    } 
    
    private String CAccountNo;
    public void setAccountNo(String AccountNo)
    {
        this.CAccountNo = AccountNo;
    }
    public String getAccountNo()
    {
        return this.CAccountNo;
    } 
    
  
    
    private long CBalance;
    public void setBalance(long Balance)
    {
        this.CBalance = Balance;
    }
    public long getBalance()
    {
        return this.CBalance;
    } 
    
    
    int printStatement;
    double zakat;
    String date = "";

   

    void makeDeposit(int amount, String date1)
    {
        CBalance = CBalance + amount;
        printStatement = amount;
        date = date1;
    }

    void makeWithdrawal(int amount,String date1)
    {
        CBalance = CBalance-amount;
        printStatement = printStatement - amount;
        date = date1;
    }

    void checkBalance()
    {
        System.out.println(CBalance);
    }

    void getprintStatement() throws ParseException
    {
        if(printStatement < 0)
        {
            System.out.println("Withdrawn: "+Math.abs(printStatement));
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
            System.out.println(date1);  
        }
        else if(printStatement > 0)
        {
            System.out.println("Deposited: "+printStatement);
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
            System.out.println(date1);  
        }
        else
        {
            System.out.println("No transaction occured");
        }
    }
    void transferAmount()
    {

    }
    void calculateZakat()
    {
        if(CBalance >= 20000)
        {
            zakat = (CBalance * 2.5)/100;
            System.out.print("Zakat eligible on your Amount is "+zakat+"-Rs. ");
        }
        else
        {
            System.out.print("Zakat is only eligible for Amount greater than or equal to 20000-Rs.");
        }
    }
    //void displayAllDeductions()
    //{

    //}
      public void CreateAccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the Customer: ");
        String Name = sc.nextLine();
        this.setCName(Name);
        
        System.out.print("Enter the address of the Customer: ");
        String Address = sc.nextLine();
        this.setCAddress(Address);
        
        System.out.print("Enter the phone no. of the Customer: ");
        String PhoneNo = sc.nextLine();
        this.setCPhoneNo(PhoneNo);
        
        System.out.print("Enter the account no. of the Customer: ");
        String AccountNo = sc.nextLine();
        this.setAccountNo(AccountNo);
    }

    void showMenu() throws ParseException
    {
        int option = 0;
        int option1 = 0;
        int key=0;
        Scanner obj1 = new Scanner(System.in);
        
        System.out.println("Welcome To Islamic Banking System.\n");
        while(option != 3)
        {
        System.out.println("1. Create Account");
        System.out.println("2. Log In to an Account");
        System.out.println("3. Exit");
        
                System.out.print("Enter the Option No: ");
                option = obj1.nextInt();
                if(option == 1)
                {
                    CreateAccount();
                }

                else if(option == 2)
                {
                    System.out.println("Welcome "+BankAccount.this.getCName());
                    System.out.println("Account number "+BankAccount.this.getAccountNo());
                    System.out.println("\n");
                    while(option1 != 6 )
                    {
                    System.out.println("1.checkBalance");
                    System.out.println("2.makeDeposit");
                    System.out.println("3.makeWithdrawal");
                    System.out.println("4.printStatement");
                    System.out.println("5.Calculate Zakat");
                    
                    System.out.println("6.Exit");

                    
                        System.out.print("Enter the Function No. you want to perform: ");
                        option1 = obj1.nextInt();

                        switch(option1)
                        {
                            case 1:
                                System.out.println("your balance is:"+CBalance+"-Rs");
                                break;

                            case 2:
                                System.out.println("Enter the amount you want to deposit");
                                int amount = obj1.nextInt();
                                System.out.print("Enter the date (Day/Month/Year): ");
                                String date1 = obj1.next();
                                makeDeposit(amount,date1);
                                break;

                            case 3:
                                System.out.println("Enetr the amount you want to withdraw");
                                int amount2 = obj1.nextInt();
                                System.out.print("Enter the date (Day/Month/Year): ");
                                String date2 = obj1.next();
                                makeWithdrawal(amount2,date2);
                                break;

                            case 4:
                                getprintStatement();
                                break;
                                
                            case 5:
                                calculateZakat();
                                break;
                                
                            case 6:
                                
                                break;

                            default:
                                System.out.println("Invalid option. please choose from 1 to 4");
                                break;
                        }
                        System.out.println("Thankyou\n");
                        System.out.println("==========================================\n");
                    }
              }
        }
    }
}

class SavingsAccount extends BankAccount
{
    Scanner obj1 = new Scanner(System.in);
    public double interest;
    public double Cinterest_rate = 0;
//    public void setinterest_rate(double interest_rate)
//    {
//        this.Cinterest_rate = interest_rate;
//    }
//     public double getinterest_rate()
//    {
//        return this.Cinterest_rate;
//    }
     
    public double calculate_interest()
    {
        System.out.print("Enter the Interest rate :");
        Cinterest_rate = obj1.nextDouble();
        interest = this.getBalance() * (Cinterest_rate)/100;
        return interest;
        
    }
    
     
}
   

//class CheckingAccount extends BankAccount
//{
//    
//}