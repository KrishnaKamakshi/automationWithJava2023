package designPatternTest;

import FlutenPatterns.InterfaceTest;
import FlutenPatterns.InterfaceTest2;
import FlutenPatterns.LoginPage;
import org.testng.annotations.Test;

public class testLoginAndProductSearch implements InterfaceTest, InterfaceTest2 {

    LoginPage loginPage = new LoginPage();
    @Test
    public void testProductSearch()
    {
        loginPage.doLogin("testqa@indevqa.ws", "password");
        System.out.println(a);
        System.out.println(b);
    }
    // Method Chaining
    @Test
    public void testMethodChaining()
    {
        loginPage.enterEmail("testqa2@indevqa.ws").enterPassword("pass").doLogin();
    }
}
