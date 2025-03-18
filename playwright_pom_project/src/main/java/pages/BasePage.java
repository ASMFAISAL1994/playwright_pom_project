package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void click(Locator locator) {
        locator.click();
    }

    public void fill(Locator locator, String text) {
        locator.fill(text);
    }

    public void assertContainsText(Locator locator, String text) {
        assert locator.innerText().contains(text) : "Text not found: " + text;
    }
}
