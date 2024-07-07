package pageobjects;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardThreePage extends Form {
    public CardThreePage() {
        super(By.xpath("//div[@class='personal-details__form']"), "Unique Element");
    }

}
