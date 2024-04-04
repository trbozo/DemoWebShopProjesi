package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class US201_TC01 extends BaseDriver {
    @Test
    public void registerTest() {

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("#gender-male")));
        action.sendKeys(driver.findElement(By.cssSelector("#FirstName")), "Faster");
        action.sendKeys(driver.findElement(By.cssSelector("#LastName")), "Tester");
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "fastest90@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Qwerty12");
        action.sendKeys(driver.findElement(By.cssSelector("#ConfirmPassword")), "Qwerty12");
        action.click(driver.findElement(By.cssSelector("#register-button")));
        action.perform();

        try {
            String result = driver.findElement(By.cssSelector(".page-body > .result")).getText();
            Assert.assertEquals("Your registration completed", result);
            action.click(driver.findElement(By.cssSelector(".header-links > ul > li + li > a.ico-logout")));
        } catch (Exception e) {
            System.out.println("Since the membership has been created in a previous step, we can skip this one.");
        }
        delayQuit();
    }
}
