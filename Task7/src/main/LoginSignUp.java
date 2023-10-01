package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoginSignUp
{
    private ArrayList<User> users;

    public LoginSignUp() {
        User u1 = new User("Khaled", "k@gmail.com","123");
        User u2 = new User("Tamer", "t@gmail.com","111");
        User u3 = new User("Aly", "a@gmail.com","000");
        this.users = new ArrayList<User>(Arrays.asList(u1, u2, u3));
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
        catch (NotValidMailException e)
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
    public void loginPage() throws NotValidMailException {
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
    }
    public boolean signUp(String name, String email, String password) throws NotValidMailException {
        if(!email.contains("@"))
            throw new NotValidMailException();
        for(User user: this.users)
        {
            if(user.getEmail().equals(email))
                return false;
        }
        this.users.add(new User(name, email, password));
        return true;
    }
    public void signUpPage() throws NotValidMailException {
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

    public static void main(String[] args) {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.start();
    }
}
