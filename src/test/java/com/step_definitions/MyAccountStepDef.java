package com.step_definitions;

import com.github.javafaker.Faker;
import com.pages.MyAcount;
import com.pages.Tshirt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class MyAccountStepDef {

    private int MAX_LENGTH_FAKE_NAME= 7;
    private Tshirt tshirt = new Tshirt();
    private MyAcount myaccount = new MyAcount();
    private Faker  fakeName = new Faker(new Random(MAX_LENGTH_FAKE_NAME));

    @Given("user is on the given url")
    public void userIsOnTheGivenUrl() {
        System.out.println("User is on home page");
        myaccount.clickSignIn();

    }

    @And("user sign in with email {string} and password {string}")
    public void userSignInWithEmailAndPassword(String email, String password) {
        myaccount.login(email,password);

    }

    @Given("user is on the My personel info")
    public void user_is_on_the_my_personel_info() {
        myaccount.clickMyPersonelInfo();


    }
    @When("user update his or her first name")
    public void user_update_his_or_her_first_name() {
        myaccount.changeMyfirstname(fakeName.name().firstName());
        myaccount.sendOldPassword("Elbistan4634");
        myaccount.sendPassword("Elbistan4634");
        myaccount.sendConfirmation("Elbistan4634");
    }
    @Then("user firstname must be change")
    public void user_firstname_must_be_change() {
        myaccount.accountConfirmation(fakeName.name().firstName());

    }

}
