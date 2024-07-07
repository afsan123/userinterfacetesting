package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.*;

public class UserInterfaceTest extends BaseClass{

    @Test
    public void testCaseOne() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page not Open");
        homePage.clickNextPageLink();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page not Open");

        String email = RandomEmailGenerator.generateRandomEmail();
        String password = email + RandomPasswordGenerator.generateRandomPassword(email);
        String domain = "example";
        String domainOptions = ".com";

        Assert.assertEquals(PageIndicator.getCurrentPageNumber(), 1, "Card " + PageIndicator.getCurrentPageNumber() + " is not open");

        CardOnePage cardOnePage = new CardOnePage();
        Assert.assertTrue(cardOnePage.state().waitForDisplayed(), "Card One Didn't Open");

        cardOnePage.enterEmail(email);
        cardOnePage.enterPassword(password);
        cardOnePage.enterDomain(domain);
        cardOnePage.selectDomainOption(domainOptions);
        cardOnePage.acceptTerms();
        cardOnePage.sendToNextCard();
        Assert.assertEquals(PageIndicator.getCurrentPageNumber(), 2, "Card " + PageIndicator.getCurrentPageNumber() + " is not open");

        CardTwoPage cardTwoPage = new CardTwoPage();
        Assert.assertTrue(cardTwoPage.state().waitForDisplayed(), "Card 2 Page Not Opened");

        cardTwoPage.uploadAvatar();
        String imagePath = ImagePath.getImagePath(TestDataReader.getAvatarImage());
        ImageUploadUtility.uploadImage(imagePath);

        cardTwoPage.unselectAllInserts();
        cardTwoPage.selectInterests(TestDataReader.getInterestCount());
        cardTwoPage.clickNextButton();

        CardThreePage cardThreePage = new CardThreePage();
        Assert.assertTrue(cardThreePage.state().waitForDisplayed(), "Card 3 Page Not Opened");
        Assert.assertEquals(PageIndicator.getCurrentPageNumber(), 3, "Card " + PageIndicator.getCurrentPageNumber() + " is not open");
    }

    @Test
    public void testCaseTwo() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page not Open");
        homePage.clickNextPageLink();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page not Open");
        gamePage.sendToBottom();

        // Wait for the class attribute to change to "help-form is-hidden" with a timeout of 10 seconds
        boolean isHidden = gamePage.waitForHelpFormToChangeClassTo();
        Assert.assertTrue(isHidden, "Help form did not change to 'help-form is-hidden' after clicking 'Send to Bottom' button.");
    }

    @Test
    public void testCaseThree() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page not Open");
        homePage.clickNextPageLink();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page not Open");
        gamePage.acceptCookies();
        Assert.assertFalse(gamePage.isCookiesMessageVisible(), "Cookies message is still visible after accepting cookies");
    }

    @Test
    public void testCaseFour() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page not Open");
        homePage.clickNextPageLink();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page not Open");
        Assert.assertTrue(gamePage.getTimerText().contains(TestDataReader.getTimerValue()), "Timer Didn't Start from 00:00");
    }
}
