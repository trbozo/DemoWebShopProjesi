package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class US203_TC01 extends BaseDriver {
    Actions action = new Actions(driver);

    @Test
    public void logoutTest() {

        driver.get("https://demowebshop.tricentis.com/");
        login();

        // Logout
        action.click(driver.findElement(By.cssSelector(".ico-logout"))).perform();
        String logIn = driver.findElement(By.cssSelector(".ico-login")).getText();
        Assert.assertEquals("Log in", logIn);

        delayQuit();
    }

    public void login(){
        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "fastest90@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Qwerty12");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();
    }
}
