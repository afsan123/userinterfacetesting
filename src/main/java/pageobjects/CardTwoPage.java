package pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;



import java.util.Collections;
import java.util.List;

public class CardTwoPage extends Form {
    private final ICheckBox unselectAllButton = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "Unselect All Button");
    private final IButton uploadImage = getElementFactory().getButton(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Image Upload Button");
    private final IButton nextCardButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--stroked') and contains(@class, 'button--white') and contains(@class, 'button--fluid')]"),"Next Button");
    private final List<ICheckBox> checkBoxes = getElementFactory().findElements(By.xpath("//span[@class='checkbox small']"), ElementType.CHECKBOX);

    public CardTwoPage() {
        super(By.xpath("//h2[@class='avatar-and-interests__title' and contains(text(), 'Choose 3 interests')]"), "Unique Element");
    }

    public void unselectAllInserts() {
        unselectAllButton.clickAndWait();
    }

    public void selectInterests(int interestCount) {
        Collections.shuffle(checkBoxes);
        int count = 0;

        for (ICheckBox checkBox : checkBoxes) {
            AqualityServices.getLogger().info("Selecting interest: " + checkBox.getText());

            checkBox.getJsActions().scrollIntoView();

            // Check if the checkbox text is "Select all" or "Unselect all"
            if (checkBox.getText().equals("Select all") || checkBox.getText().equals("Unselect all")) {
                if (checkBox.isChecked()) {
                    checkBox.clickAndWait();
                }
                continue;
            }

            if (!checkBox.isChecked()) {
                checkBox.clickAndWait();
                count++;
            }

            if (count >= interestCount) {
                break;
            }
        }
    }


    public void uploadAvatar() {
        uploadImage.clickAndWait();
    }

    public void clickNextButton() {
        nextCardButton.clickAndWait();
    }

}
