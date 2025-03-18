package pages;

import com.microsoft.playwright.Page;

public class InventoryPage extends BasePage {

    private final String title = "[data-test=\"title\"]";
    private final String backpackTitle = "[data-test=\"item-4-title-link\"] [data-test=\"inventory-item-name\"]";
    private final String addToCartBackpack = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    private final String cartIcon = "[data-test=\"shopping-cart-link\"]";

    public InventoryPage(Page page) {
        super(page);
    }

    public void verifyProductPage() {
        assertContainsText(page.locator(title), "Products");
    }

    public void addBackpackToCart() {
        assertContainsText(page.locator(backpackTitle), "Sauce Labs Backpack");
        click(page.locator(addToCartBackpack));
    }

    public void goToCart() {
        click(page.locator(cartIcon));
    }
}
