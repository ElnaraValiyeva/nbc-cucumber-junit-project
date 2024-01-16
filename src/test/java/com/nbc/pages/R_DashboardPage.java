package com.nbc.pages;

import com.nbc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class R_DashboardPage {

    public R_DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy()
    public List<WebElement> allTopModules;


}
