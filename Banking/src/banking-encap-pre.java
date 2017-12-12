// the banking example with exception for the customer not being found

import java.util.LinkedList;
import java.util.Scanner;

// ************** The Exceptions ***********************

class CustNotFoundException extends Exception {
  private String unfoundName;
  
  CustNotFoundException(String name) {
    this.unfoundName = name;
  }
  
  public String getUnfoundName() {
    return this.unfoundName;
  }
}

// ************** Encapsulated Customer Sets *************

interface ICustSet {
  Customer findByName(String name) throws CustNotFoundException;
}

class CustSet implements ICustSet {
  private LinkedList<Customer> customers = new LinkedList<Customer>();
  
  // adds customer to the list of customers
  public void addCust(Customer newC) {
    this.customers.add(newC);
  }
  
  // returns Customer with given name, or throws exception if no such customer
  public Customer findByName(String name) throws CustNotFoundException {
    for (Customer cust:customers) {    
      if (cust.nameMatches(name))
        return cust;
    }
    throw new CustNotFoundException(name);
  }
}

// ************** Encapsulated Account Sets **************

interface IAccountSet {
  Account findByNum(int number) ;
}

class AcctSet implements IAccountSet {
  private LinkedList<Account> accounts = new LinkedList<Account>();
  
  // returns Account with given number, or throws exception if no such account
  public Account findByNum(int num) {
    for (Account acct:accounts) {                
      if (acct.numMatches(num))
        return acct;
    }
    return null;  // this should not be here -- replace with exception
  }
}

// ************** Customer Class *************

class Customer {
  private String name;   
  private int password;  
  private LinkedList<Account> accounts; 
  
  Customer(String name, int password) {
    this.name = name;
    this.password = password;
    this.accounts = new LinkedList<Account>();
  }
  
  // check whether customer has given name
  public boolean nameMatches(String aname) {
      return (this.name.equals(aname));
  }
   
  // check whether the given password matches the one for this user
  // in a real system, this method would return some object with
  // info about the customer, not just a string
  public String tryLogin(int withPwd) {
    if (this.password == withPwd)
      return "Welcome";
    else
      return "Oops--password failed";
  }
}

// ************** Account Class *************

class Account {
  private int number;      
  private Customer owner;  
  private double balance;  
  
  // check whether account has given num
  public boolean numMatches(int anum) {
      return (this.number == anum);
  }
  
  // returns the balance in this account
  public double getBalance() {
    return this.balance;
  }
  
  // method to withdraw given amount
  public double withdraw(double amt) {
    this.balance = this.balance - amt;
    return amt;
  }
}

// ************** The Banking Service *************

class BankingService {
  private IAccountSet accounts;   
  private ICustSet customers; 
  
  BankingService(IAccountSet accounts, ICustSet customers) {
    this.accounts = accounts;
    this.customers = customers;
  }
  
  // this method should be allowed to assume that the acct num is valid
  // some other method has task of handling that problem
  public double getBalance(int forAcctNum) {  
    Account acct = accounts.findByNum(forAcctNum) ;
    return acct.getBalance();
  }
  
  // this method should be allowed to assume that the acct num is valid
  // some other method has task of handling that problem
  public double withdraw(int forAcctNum, double amt) {  
    Account acct = accounts.findByNum(forAcctNum) ;
    return acct.withdraw(amt);
  }
  
  public void login(String custname, int withPwd) throws CustNotFoundException {
    Customer cust = customers.findByName(custname);
    cust.tryLogin(withPwd); 
  } 
}

class BankingConsole {
  BankingService B;
  private Scanner keyboard = new Scanner(System.in);
  
  BankingConsole(BankingService B) {
    this.B = B;
  }

  // displays the login screen for the banking software,
  //   reads login data, and attempts to log user in.
  public void loginScreen() {
    // prompt for user to enter name and password
    System.out.println("Welcome to the Bank.  Please log in.");
    System.out.print("Enter your username: ");
    String username = keyboard.next();
    System.out.print("Enter your password: ");
    int password = keyboard.nextInt();
    try {
      B.login(username,password);
      System.out.println("Login successful");
    } catch (CustNotFoundException e) {
      System.out.println("Login Failed. Try Again");
      this.loginScreen();
    }
  }

}

// ************** Examples *************

class Examples {
  Customer gompeiCust = new Customer("gompei", 1865);
 
 // method to initialize a banking service with Gompei as the customer
  BankingService setUpGompei() {
    CustSet allCusts = new CustSet();
    allCusts.addCust(gompeiCust);
    return new BankingService(new AcctSet(), allCusts);
  } 
}

// ************** Main ******************
class Main {  
  public static void main(String[] args) {
    BankingService B = new Examples().setUpGompei(); 
    BankingConsole C = new BankingConsole(B);
    C.loginScreen();
  }
}
