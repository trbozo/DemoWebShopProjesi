

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class TC_0201 extends BaseDriver {

    @Test
    public void _US_202_RegisterNegative(){

        try {

            driver.get("https://demowebshop.tricentis.com/");


            WebElement registerButton = driver.findElement(By.linkText("Register"));
            registerButton.click();


            Actions actions = new Actions(driver);
            WebElement firstName = driver.findElement(By.id("FirstName"));
            WebElement lastName = driver.findElement(By.id("LastName"));
            WebElement maleRadioButton = driver.findElement(By.id("gender-female"));
            WebElement email = driver.findElement(By.id("Email"));
            WebElement password = driver.findElement(By.id("Password"));
            WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
            WebElement registerButton2 = driver.findElement(By.id("register-button"));
            MyFunc.Bekle(3);
            actions.moveToElement(firstName)
                    .click()
                    .sendKeys("test")
                    .sendKeys(Keys.TAB)
                    .sendKeys("Tester")
                    .sendKeys(Keys.TAB)
                    .click(maleRadioButton)
                    .sendKeys(Keys.TAB)
                    .click(email)
                    .sendKeys("test123@gmail.com")
                    .sendKeys(Keys.TAB)
                    .click(password)
                    .sendKeys("Test123")
                    .sendKeys(Keys.TAB)
                    .sendKeys("Test123")
                    .sendKeys(Keys.TAB)
                    .click(registerButton2)
                    .perform();

            WebElement mailExist= driver.findElement(By.xpath("//*[text()='The specified email already exists']"));
            Assert.assertTrue("Email hata mesaji bulunamadi",mailExist.getText().contains("The specified email already exists"));
        } finally {
            driver.quit();
        }
    }

}