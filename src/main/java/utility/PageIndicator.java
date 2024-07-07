package utility;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.By;

public class PageIndicator {
    private static final IElement pageIndicatorElement = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//div[@class='page-indicator']"), "Page Indicator");

    public static int getCurrentPageNumber() {
        String pageIndicatorText = pageIndicatorElement.getText();
        String[] parts = pageIndicatorText.split("/");
        return Integer.parseInt(parts[0].trim());
    }
}
