package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoginSignUp
{

    private ArrayList<User> users;

    public LoginSignUp()
    {
        User u1 = new User("Khaled", "k@gmail.com","123", "1");
        User u2 = new User("Tamer", "t@gmail.com","111", "2");
        User u3 = new User("Aly", "a@gmail.com","000", "3");
        this.users = new ArrayList<User>(Arrays.asList(u1, u2, u3));
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void start() {
        try {
            System.out.print("Login: press 1, Sign up: press any other number ");
            Scanner sc = new Scanner(System.in);
            int str = sc.nextInt();
            if (str == 1)
                this.loginPage();
            else
                this.signUpPage();
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public boolean login(String email, String password) throws NotValidMailException {
        if(!email.contains("@"))
            throw new NotValidMailException();
        for(User user: this.users)
        {
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
            {
                System.out.println("Welcome, " + user.getName());
                return true;
            }
        }
        System.out.println("Credentials Incorrect or User not found");
        return false;
    }
    public void loginPage() throws NotValidMailException, AccountAlreadyExistsException, WrongAccountException, InsufficientFundsException {
        System.out.println("Welcome to login in page ");

        System.out.println();

        System.out.print("Enter email: ");
        Scanner sc= new Scanner(System.in);
        String email= sc.nextLine();

        System.out.println();

        System.out.print("Enter password: ");
        sc= new Scanner(System.in);
        String password= sc.nextLine();

        boolean isSuccess  =  this.login(email, password);
        if(!isSuccess)
            this.start();
        else
        {
            this.homepage(email, password);
        }
    }
    public void homepage(String email, String password) throws NotValidMailException, AccountAlreadyExistsException, WrongAccountException, InsufficientFundsException {
        System.out.println("Display account? Press 1");
        System.out.println("Add account? Press 2");
        System.out.println("Withdraw from account? Press 3");
        System.out.println("Deposit from account? Press 4");
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        if (str.equals("1"))
        {
            boolean isSuccess = this.displayAccountsOf(email);
            this.homepage(email, password);
        }
        else if(str.equals("2"))
        {
            this.addAccount(email, password);
        }
        else if(str.equals("3"))
        {
            System.out.println("Enter account id");
            sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            System.out.println("Enter amount to withdraw: ");
            String str2 = sc.nextLine();

            for(User user: this.users)
            {
                if(user.getEmail().equals(email))
                {
                    user.withdraw(str1, Integer.parseInt(str2));
                }
            }
            this.homepage(email, password);
        }
        else if(str.equals("4"))
        {
            System.out.println("Enter account id");
            sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            System.out.println("Enter amount to deposit: ");
            String str2 = sc.nextLine();

            for(User user: this.users)
            {
                if(user.getEmail().equals(email))
                {
                    user.deposit(str1, Integer.parseInt(str2));
                }
            }
            this.homepage(email, password);
        }
        else
            this.login(email, password);
    }
    public void addAccount(String email, String password) throws AccountAlreadyExistsException, NotValidMailException, WrongAccountException, InsufficientFundsException {
        System.out.println("Enter Type credit or savings?: C/S");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("C") || str.equals("c"))
            str = "Credit";
        else
            str = "Savings";
        System.out.println("Enter id: ");
        String str2 = sc.nextLine();

        for(User user: this.users)
        {
            if(user.getEmail().equals(email))
            {
                user.addAccount(str, str2);
            }
        }
        this.homepage(email, password);
    }
    public boolean signUp(String name, String email, String password) throws NotValidMailException {
        if(!email.contains("@"))
            throw new NotValidMailException();
        for(User user: this.users)
        {
            if(user.getEmail().equals(email))
                return false;
        }
        this.users.add(new User(name, email, password, this.users.size()+""));
        return true;
    }
    public void signUpPage() throws NotValidMailException, AccountAlreadyExistsException, WrongAccountException, InsufficientFundsException {
        System.out.println("Welcome to sign up page ");

        System.out.print("Enter a name: ");
        Scanner sc= new Scanner(System.in);
        String name= sc.nextLine();

        System.out.println();

        System.out.print("Enter an email: ");
        sc= new Scanner(System.in);
        String email= sc.nextLine();

        System.out.println();

        System.out.print("Enter a password: ");
        sc= new Scanner(System.in);
        String password= sc.nextLine();

        boolean isSuccess =this.signUp(name, email, password);
        if(!isSuccess)
        {
            System.out.print("User Already Exists, Would you like to login Y/n: ");
            sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("Y") || str.equals("y"))
                this.loginPage();
            else
                this.signUpPage();
        }
        else
            this.loginPage();
    }
    public boolean displayAccountsOf(String email)
    {
        for(User user: this.users)
        {
            if(user.getEmail().equals(email))
            {
                for(Account account: user.getAccounts())
                    account.print();
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.start();
    }
}
