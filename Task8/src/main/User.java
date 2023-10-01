package main;

import java.util.ArrayList;

public class User
{
    private String name;
    private String email;
    private String password;
    private String id;
    private ArrayList<Account> accounts;

    public User(String name, String email, String password, String id)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
        this.accounts = new ArrayList<Account>();
    }
    public String getId() {
        return id;
    }

    public void addAccount(String type, String id) throws AccountAlreadyExistsException {
        for(Account account: this.getAccounts())
        {
            if(account.getAccountID().equals(id))
                throw new AccountAlreadyExistsException();
        }
        this.accounts.add(new Account(type, id, this.id));
    }
    public void deposit(String accountID, int amount) throws WrongAccountException {
        for(Account account: this.getAccounts())
        {
            if(account.getAccountID().equals(accountID))
            {
                account.setBalance(account.getBalance()+amount);
                return;
            }
        }
        throw new WrongAccountException();
    }
    public void withdraw(String accountID, int amount) throws InsufficientFundsException, WrongAccountException {
        for(Account account: this.getAccounts())
        {
            if(account.getAccountID().equals(accountID))
            {
                if(account.getBalance()< amount)
                    throw new InsufficientFundsException();
                else
                    account.setBalance(account.getBalance()-amount);

                return;
            }
        }
        throw new WrongAccountException();
    }
    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
