package pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    private final String cartHeader = "[data-test=\"secondary-header\"]";
    private final String checkoutButton = "[data-test=\"checkout\"]";

    public CartPage(Page page) {
        super(page);
    }

    public void verifyCart() {
        assertContainsText(page.locator(cartHeader), "Your Cart");
    }

    public void proceedToCheckout() {
        click(page.locator(checkoutButton));
    }
}
