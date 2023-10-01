package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginSignUpTest {

    @Test
    void withdrawSuccess() throws WrongAccountException, InsufficientFundsException, AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "1");
        loginSignUp.getUsers().get(0).getAccounts().get(0).setBalance(100);
        loginSignUp.getUsers().get(0).withdraw("1", 50);
        assertEquals(50, loginSignUp.getUsers().get(0).getAccounts().get(0).getBalance());
    }
    @Test
    void withdrawFailureInsuffientFunds() throws AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "1");
        loginSignUp.getUsers().get(0).getAccounts().get(0).setBalance(100);
        assertThrows(InsufficientFundsException.class, ()-> {
            loginSignUp.getUsers().get(0).withdraw("1", 200);
        });
    }
    @Test
    void withdrawFailureWrongAccount() throws AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "1");
        loginSignUp.getUsers().get(0).getAccounts().get(0).setBalance(100);
        assertThrows(WrongAccountException.class, ()-> {
            loginSignUp.getUsers().get(0).withdraw("2", 100);
        });
    }
    @Test
    void depositSuccess() throws WrongAccountException, AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "1");
        loginSignUp.getUsers().get(0).deposit("1", 50);
        assertEquals(50, loginSignUp.getUsers().get(0).getAccounts().get(0).getBalance());
    }
    @Test
    void depositFailureWrongAccount() throws AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "1");
        loginSignUp.getUsers().get(0).getAccounts().get(0).setBalance(100);
        assertThrows(WrongAccountException.class, ()-> {
            loginSignUp.getUsers().get(0).deposit("2", 100);
        });
    }

    @Test
    void addNewAccountSuccess() throws AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "ACC1");
        assertEquals(1, loginSignUp.getUsers().get(0).getAccounts().size());
    }
    @Test
    void addNewAccountFailureAccountAlreadyExists() throws AccountAlreadyExistsException {
        LoginSignUp loginSignUp = new LoginSignUp();
        loginSignUp.getUsers().get(0).addAccount("Savings", "ACC1");
        assertThrows(AccountAlreadyExistsException.class, ()->{
            loginSignUp.getUsers().get(0).addAccount("Credit", "ACC1");
        });
    }



    @Test
    void loginSuccess() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertTrue(loginSignUp.login("k@gmail.com", "123"));
    }
    @Test
    void loginFailureNoUser() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertFalse(loginSignUp.login("h@gmail.com", "111"));
        assertThrows(NotValidMailException.class, ()->{
            loginSignUp.login("k", "122");
        });
    }
    @Test
    void loginFailureInvalidEmailFormat() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertThrows(NotValidMailException.class, ()->{
            loginSignUp.login("k", "122");
        });
    }
    @Test
    void signUpSuccess() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertTrue(loginSignUp.signUp("New","new@gmail.com", "123"));
        assertEquals(4, loginSignUp.getUsers().size());
    }
    @Test
    void signUpFailureUserAlreadyExists() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertFalse(loginSignUp.signUp("Khaled", "k@gmail.com", "111"));
        assertEquals(3, loginSignUp.getUsers().size());
    }
    @Test
    void signUpFailureIncorrectEmail() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertThrows(NotValidMailException.class, ()->{
            loginSignUp.signUp("Khaled", "kgmail.com", "111");
        });
        assertEquals(3, loginSignUp.getUsers().size());
    }
}