package com.pages;

import com.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tshirt extends BasePage {

    @FindBy(css="[title='T-shirts']")
    public WebElement tshirtButton;

    public void clickTshirtButton() {
        tshirtButton.click();
    }

}
