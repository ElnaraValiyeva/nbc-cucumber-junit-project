package com.nbc.utilities;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BrowserUtils {

    /*
    This method will accept int (in seconds)
    and execute Thread.sleep method for given duration
    Arg: int second
     */
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){

        //Return and store all window handles in a Set.
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL )){
                break;
            }
        }
        //5. Assert:Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /*
   This method accepts WebElement target,
   and waits for that WebElement not to be displayed on the page
    */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
   This method accepts String title,
   and waits for that Title to contain given String value.
    */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }


    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
}
