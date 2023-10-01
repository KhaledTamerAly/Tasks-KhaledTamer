package main;

public class WrongAccountException extends Exception{
    public WrongAccountException(){super("You don't have access to this account");}
}
