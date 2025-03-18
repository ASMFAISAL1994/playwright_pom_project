package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final String usernameField = "[data-test=\"username\"]";
    private final String passwordField = "[data-test=\"password\"]";
    private final String loginButton = "xpath=//input[@id='login-button']";

    public LoginPage(Page page) {
        super(page);
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        fill(page.locator(usernameField), username);
        fill(page.locator(passwordField), password);
        click(page.locator(loginButton));
    }
}
