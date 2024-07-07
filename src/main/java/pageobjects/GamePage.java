package pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utility.ConfigReader;


import java.time.Duration;

public class GamePage extends Form {
    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'help-form__send-to-bottom-button') and //span[@class='highlight' and text()='Send']]"), "Send to Bottom Button");
    private final ILabel helpFormElement = getElementFactory().getLabel(By.cssSelector(".help-form"), "Help Form");
    private final IButton cookiesAcceptButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--solid') and contains(@class, 'button--transparent') and contains(text(), 'Not really, no')]"), "Cookies Accept Button");
    private final IElement timerElement = getElementFactory().getLabel(By.xpath("//div[@class='timer timer--white timer--center']"), "timer Element");
    private final ITextBox cookiesMessage = getElementFactory().getTextBox(By.xpath("//p[@class='cookies__message']"), "Cookies Message");
    public GamePage() {
        super(By.xpath("//div[@class='timer timer--white timer--center']"), "Game Page");
    }

    public void sendToBottom() {
        sendToBottomButton.click();
    }

    public boolean waitForHelpFormToChangeClassTo() {
        return AqualityServices.getConditionalWait().waitFor(
                () -> helpFormElement.getAttribute("class").contains("help-form is-hidden"),
                Duration.ofSeconds(ConfigReader.getTimeoutSeconds())
        );
    }
    public void acceptCookies() {
        cookiesAcceptButton.click();
        cookiesMessage.state().waitForNotDisplayed();
    }

    public boolean isCookiesMessageVisible() {
        return cookiesMessage.state().isDisplayed();
    }

    public String getTimerText() {
        return timerElement.getText();
    }

}
