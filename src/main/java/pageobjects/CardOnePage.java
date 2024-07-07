package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardOnePage extends Form {
    private final ITextBox passwordInput = getElementFactory().getTextBox(By.cssSelector("input[placeholder='Choose Password']"), "Password Input");
    private final ITextBox emailInput = getElementFactory().getTextBox(By.cssSelector("input[placeholder='Your email']"), "Email Input");
    private final ITextBox domainInput = getElementFactory().getTextBox(By.cssSelector("input[placeholder='Domain']"), "Domain Input");
    private final ILabel dropDownHeader = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'dropdown__field') and contains(text(),'other')]"), "Domain Dropdown");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'button--secondary') and contains(text(),'Next')]"), "Next Button");

    private final ICheckBox acceptTermsCheckBox = getElementFactory().getCheckBox(By.xpath("//label[@for='accept-terms-conditions']"), "Accept Terms Checkbox");

    public CardOnePage() {
        super(By.xpath("//a[contains(@class, 'login-form__terms-conditions')]"), "Card One Unique Element");
    }
    public void enterPassword(String password) {
        passwordInput.clearAndType(password);
    }

    public void enterEmail(String email) {
        emailInput.clearAndType(email);
    }

    public void enterDomain(String domain) {
        domainInput.clearAndType(domain);
    }

    private ILabel findDomainOption(String optionText) {
        String xpathExpression = String.format("//div[@class='dropdown__list-item' and text()='%s']", optionText);
        return getElementFactory().getLabel(By.xpath(xpathExpression), "Domain Option: " + optionText);
    }


    public void clickDomainOption(String optionText) {
        ILabel domainOption = findDomainOption(optionText);
        domainOption.clickAndWait();
    }

    public void selectDomainOption(String option) {
        dropDownHeader.click();
        clickDomainOption(option);
    }

    public void sendToNextCard() {
        nextButton.clickAndWait();
    }

    public void acceptTerms() {
        acceptTermsCheckBox.check();
    }



}
