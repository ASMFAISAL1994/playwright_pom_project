package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    private final String firstNameField = "[data-test=\"firstName\"]";
    private final String lastNameField = "[data-test=\"lastName\"]";
    private final String postalCodeField = "[data-test=\"postalCode\"]";
    private final String continueButton = "[data-test=\"continue\"]";
    private final String finishButton = "[data-test=\"finish\"]";
    private final String checkoutHeader = "[data-test=\"secondary-header\"]";
    private final String completeHeader = "[data-test=\"complete-header\"]";

    public CheckoutPage(Page page) {
        super(page);
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        fill(page.locator(firstNameField), firstName);
        fill(page.locator(lastNameField), lastName);
        fill(page.locator(postalCodeField), postalCode);
        click(page.locator(continueButton));
    }

    public void completeOrder() {
        assertContainsText(page.locator(checkoutHeader), "Checkout: Overview");
        click(page.locator(finishButton));
        assertContainsText(page.locator(completeHeader), "Thank you for your order!");
    }
}
