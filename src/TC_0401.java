import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TC_0401 extends BaseDriver {

 @Test
   public void _US_204(){

driver.get("https://demowebshop.tricentis.com/");

     WebElement login= driver.findElement(By.xpath("//a[text()='Log in']"));
     login.click();

    // Actions actions=new Actions(driver);

    // Action loginButton=actions.moveToElement(login).click().build();
    // actions.perform();

     WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
     email.clear();
     email.sendKeys("testingler@gmail.com");

     WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
     password.clear();
     password.sendKeys("Tester123456");

     WebElement log=driver.findElement(By.xpath("//input[@value='Log in']"));
     log.click();

      WebElement anaSayfa= driver.findElement(By.xpath("//a[@href='/books']"));


      wait.until(ExpectedConditions.textToBe(By.xpath("//strong[text()='Categories']"),"CATEGORIES"));
      WebElement msg= driver.findElement(By.xpath("//strong[text()='Categories']"));

     Assert.assertTrue("Aranilan mesag bulunamadi",msg.getText().equals("CATEGORIES"));
      BekleKapat();







 }
}
