package main;

public class Account
{
    private String type;
    private String accountID;
    private String ownerID;
    private double balance;

    public Account(String type, String accountID, String ownerID)
    {
        this.type = type;
        this.accountID = accountID + ownerID;
        this.ownerID = ownerID;
        this.balance = 0;
    }
    public void print()
    {
        System.out.println("Type: " + this.type + " Account ID: " + this.accountID + " Owner ID: " +this.ownerID + " Balance: " +this.balance);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
