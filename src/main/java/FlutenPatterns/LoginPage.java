package FlutenPatterns;

public class LoginPage {
    //methods
    public LoginPage enterEmail(String email) {
        System.out.println(email + " entered");
        //login element
        return this;
    }

    //methods
    public LoginPage enterPassword(String password) {
        System.out.println(password + " entered");
        //to do implementation
        return this;
    }

    public HomePage clickLogin() {
        System.out.println("Login clicked");
        return new HomePage();
    }

    public void doLogin(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();

    }

    public LoginPage doLogin() {
        System.out.println("User entered");
        return this;
    }
}
