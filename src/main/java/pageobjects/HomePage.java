package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private final IButton nextPageLink = getElementFactory().getButton(By.xpath("//a[@class='start__link' and contains(text(), 'HERE')]"), "Next Page Link");
    public HomePage() {
        super(By.cssSelector(".start__paragraph"), "Home Page");
    }

    public void clickNextPageLink() {
        nextPageLink.click();
    }

}
