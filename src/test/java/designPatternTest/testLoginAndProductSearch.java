package designPatternTest;

import FlutenPatterns.InterfaceTest;
import FlutenPatterns.LoginPage;
import org.testng.annotations.Test;

public class testLoginAndProductSearch implements InterfaceTest {

    LoginPage loginPage = new LoginPage();
    @Test
    public void testProductSearch()
    {
        loginPage.doLogin("testqa@indevqa.ws", "password");
        System.out.println(a);
    }

    // Method Chaining
    @Test
    public void testMethodChaining()
    {
        loginPage.enterEmail("testqa2@indevqa.ws").enterPassword("pass").doLogin();
    }
}
