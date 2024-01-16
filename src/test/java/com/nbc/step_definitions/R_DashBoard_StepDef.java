package com.nbc.step_definitions;

import com.nbc.pages.R_DashboardPage;
import com.nbc.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class R_DashBoard_StepDef {

    R_DashboardPage dashboardPage = new R_DashboardPage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModule){


        BrowserUtils.sleep(3);
        List<String> actualModules =new ArrayList<>();

        for(WebElement eachModule : dashboardPage.allTopModules){
            actualModules.add(eachModule.getText());
        }

        Assert.assertEquals(expectedModule,actualModules);



    }
}
