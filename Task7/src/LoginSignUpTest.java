import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginSignUpTest {

    @Test
    void login() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertTrue(loginSignUp.login("k@gmail.com", "123"));
        assertFalse(loginSignUp.login("h@gmail.com", "111"));
        assertThrows(NotValidMailException.class, ()->{
           loginSignUp.login("k", "122");
        });
    }

    @Test
    void signUp() throws NotValidMailException {
        LoginSignUp loginSignUp = new LoginSignUp();
        assertTrue(loginSignUp.signUp("New","new@gmail.com", "123"));
        assertFalse(loginSignUp.signUp("Khaled", "k@gmail.com", "111"));
        assertThrows(NotValidMailException.class, ()->{
            loginSignUp.signUp("Khaled", "kgmail.com", "111");
        });
    }
}