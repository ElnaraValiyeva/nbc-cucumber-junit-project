package com.nbc.step_definitions;

import com.nbc.pages.R_VytrackLoginPage;
import com.nbc.utilities.BrowserUtils;
import com.nbc.utilities.ConfigurationReader;
import com.nbc.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class R_VytrackLogin_StefDef {

    R_VytrackLoginPage loginPage = new R_VytrackLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

       // loginpage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        //loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        //loginpage.loginBtn.click();
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));


    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        BrowserUtils.sleep(5);
        Assert.assertEquals("Dashboard",Driver.getDriver().getTitle());

    }
    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),ConfigurationReader.getProperty("sales_manager_password"));
    }

    @When("user enters the store manager information")
    public void userEntersTheStoreManagerInformation() {
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"),ConfigurationReader.getProperty("store_manager_password"));
    }

    @When("user enters the {string} information")
    public void user_enters_the_information(String string) {
        loginPage.login(string);
    }


    @When("the user login with {string},{string}")
    public void the_user_login_with(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_log_in() {
        BrowserUtils.verifyTitle("Login");
    }


}
