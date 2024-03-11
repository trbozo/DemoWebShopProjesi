import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class TC_0501_Mehmet extends BaseDriver {
    @Test
    public void Test501(){
        //Step 1. Open the web browser and go to "Demowebshop.tricentis.com".
        driver.get("https://demowebshop.tricentis.com/");

        // 2. Click the "Login" button on the 2nd homepage.
        MyFunc.Bekle(2);
        WebElement LogInn= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInn.click();

        //3. Enter the information in test data in "email" and "password" areas:

        MyFunc.Bekle(2);
        WebElement Emaill= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill.sendKeys("testingler@gmail.com");

        MyFunc.Bekle(2);
        WebElement passW= driver.findElement(By.xpath("//input[@id='Password']"));
        passW.sendKeys("Tester123456");

        //4. Try to login by clicking the "Login" button ..
        MyFunc.Bekle(2);
        WebElement Loggg=driver.findElement(By.xpath("//input[@value='Log in']"));
        Loggg.click();

        MyFunc.Bekle(3);
        driver.quit();
    }

}
