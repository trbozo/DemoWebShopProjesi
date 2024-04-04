package testCase;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utility.BaseDriver;
import org.junit.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class US209_TC01 extends BaseDriver {
    @Test
    public void invoiceDisplay() {

        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        if (!driver.findElement(By.cssSelector(".ico-login")).isDisplayed()) {
            System.out.println("You are already logged out");
            return;
        }

        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "fastest90@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Qwerty12");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();
        action.click(driver.findElement(By.cssSelector(".account"))).perform();
        action.click(driver.findElement(By.xpath("(//a[text()='Orders'])[1]"))).perform();
        action.click(driver.findElement(By.xpath("(//input[@type='button'])[2]"))).perform();
        action.click(driver.findElement(By.cssSelector("[class='button-2 pdf-order-button']"))).perform();

        WebElement orderText =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".order-number")));
        String orderNumber = orderText.getText().substring(7);
        System.out.println("orderNumber = " + orderNumber);

        // The number of TABs may vary, count the tabs until reaching the downloaded PDF.
        Actions actions = new Actions(driver);
        Robot robot = null;
        driver.get("chrome://downloads");

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i <= 2; i++) {

            actions.sendKeys(Keys.TAB).perform();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            if (i == 2) {
                delay(5);   // wait for download
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }

        System.out.println("CurrentUrl before handle = " + driver.getCurrentUrl()); //

        Set<String> windowHandles = driver.getWindowHandles();
        String[] handles = windowHandles.toArray(new String[0]);
        driver.switchTo().window(handles[1]);

        String secondTabTitle = driver.getCurrentUrl();
        System.out.println("CurrentUrl after handle = " + driver.getCurrentUrl());
        System.out.println("second TAB Title = " + secondTabTitle);
        Assert.assertTrue(secondTabTitle.contains(orderNumber));
        Assert.assertTrue(driver.getCurrentUrl().contains(orderNumber));

        delayQuit();
    }
}
