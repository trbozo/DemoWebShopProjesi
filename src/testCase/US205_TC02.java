package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class US205_TC02 extends BaseDriver {
    @Test
    public void loginWithInvalidCredentialsTest2() {    // with array

        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);

        String[] emailArray = {"", "fastest90@gmail.com", "", "invalid90@gmail.com", "fastest90@gmail.com"};
        String[] passwordArray = {"", "", "Qwerty12", "invalidPwd12", "invalidPwd12"};

        try {
            action.click(driver.findElement(By.cssSelector(".ico-logout"))).perform();
        } catch (Exception e) {
            System.out.println("This step was skipped because there was no login.");
        }

        for (int i = 0; i < emailArray.length; i++) {
            action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
            action.sendKeys(driver.findElement(By.cssSelector("#Email")), emailArray[i]);
            action.sendKeys(driver.findElement(By.cssSelector("#Password")), passwordArray[i]);
            action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
            action.perform();
            String result = driver.findElement(By.cssSelector(".validation-summary-errors > span")).getText();
            Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", result);
        }

        delayQuit();
    }
}
