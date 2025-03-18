package tests;

import com.microsoft.playwright.*;
import pages.*;

public class FirstPlaywrightTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();

        LoginPage loginPage = new LoginPage(page);
        InventoryPage inventoryPage = new InventoryPage(page);
        CartPage cartPage = new CartPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);

        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.verifyProductPage();
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        cartPage.verifyCart();
        cartPage.proceedToCheckout();

        checkoutPage.enterCheckoutInfo("Asm", "Faisal", "1207");
        checkoutPage.completeOrder();

        playwright.close();
    }
}
