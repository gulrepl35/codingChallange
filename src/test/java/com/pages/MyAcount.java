package com.pages;

import com.utilities.BasePage;
import com.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.Name;

public class MyAcount extends BasePage {

    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[2]")
    public WebElement emailInput;

    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[3]")
    public WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton ;

    @FindBy(css="a[class='login']")
    public WebElement firstSignIn;

    @FindBy(css ="i[class='icon-user']" )
    public WebElement myPersonelInfo;

    @FindBy(id = "firstname")
    public WebElement myFirstName;

    @FindBy(id = "old_passwd")
    public WebElement oldpasswd;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "confirmation")
    public WebElement confirmationPassword;

    @FindBy(name="submitIdentity")
    public WebElement save;

    @FindBy(css = "a[class='account']")
    public WebElement account;



    public void login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();

    }

    public void clickSignIn() {
        firstSignIn.click();
    }
    public void clickMyPersonelInfo(){
        myPersonelInfo.click();
    }
    public void changeMyfirstname(String name){
        myFirstName.clear();
        myFirstName.sendKeys(name, Keys.ENTER);

    }
    public void sendOldPassword(String oldPassword) {
        oldpasswd.sendKeys(oldPassword,Keys.ENTER);
    }

    public void sendPassword( String password){
        passwd.sendKeys(password,Keys.ENTER);
    }

    public void sendConfirmation(String password){
        confirmationPassword.sendKeys(password,Keys.ENTER);
    }

    public void clickSave(){
        save.click();
    }

    public void accountConfirmation(String name){
        Assert.assertEquals(name,account.getText());
    }
}

