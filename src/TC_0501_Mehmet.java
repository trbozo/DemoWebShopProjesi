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
        MyFunc.Bekle(1);
        WebElement LogInFirst1= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInFirst1.click();

        //3. Enter the information in test data in "email" and "password" areas:
        MyFunc.Bekle(1);
        WebElement Emaill= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill.sendKeys("testingler@gmail.com");

        MyFunc.Bekle(1);
        WebElement passW= driver.findElement(By.xpath("//input[@id='Password']"));
        passW.sendKeys("Tester123456");

        //4. Try to login by clicking the "Login" button ..
        MyFunc.Bekle(1);
        WebElement LogggIn=driver.findElement(By.xpath("//input[@value='Log in']"));
        LogggIn.click();

        MyFunc.Bekle(1);
        WebElement LogggOut=driver.findElement(By.xpath("//a[@class='ico-logout']"));
        LogggOut.click();

        //================= negative test starts====================
        // Empty email, empty password
        WebElement LogInFirst2= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInFirst2.click();
        MyFunc.Bekle(1);

        WebElement Emaill2= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill2.sendKeys("");

        MyFunc.Bekle(1);
        WebElement passW2= driver.findElement(By.xpath("//input[@id='Password']"));
        passW2.sendKeys("");

        MyFunc.Bekle(1);
        WebElement LogggIn2=driver.findElement(By.xpath("//input[@value='Log in']"));
        LogggIn2.click();

        // Current email, empty password
        WebElement LogInFirst3= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInFirst3.click();

        WebElement Emaill3= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill3.sendKeys("testingler@gmail.com");

        MyFunc.Bekle(1);
        WebElement passW3= driver.findElement(By.xpath("//input[@id='Password']"));
        passW3.sendKeys("");

        MyFunc.Bekle(1);
        WebElement LogggIn3=driver.findElement(By.xpath("//input[@value='Log in']"));
        LogggIn3.click();

        //Empty email, valid password
        WebElement LogInFirst4= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInFirst4.click();
        MyFunc.Bekle(1);

        WebElement Emaill4= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill4.sendKeys("");

        MyFunc.Bekle(1);
        WebElement passW4= driver.findElement(By.xpath("//input[@id='Password']"));
        passW4.sendKeys("Tester123456");

        MyFunc.Bekle(1);
        WebElement LogggIn4=driver.findElement(By.xpath("//input[@value='Log in']"));
        LogggIn4.click();

        // invalid email, invalid password
        WebElement LogInFirst5= driver.findElement(By.xpath("//a[@href='/login']"));
        LogInFirst5.click();
        MyFunc.Bekle(1);

        WebElement Emaill5= driver.findElement(By.xpath("//input[@id='Email']"));
        Emaill5.sendKeys("gecersizbirmailfake@hotmail.com");

        MyFunc.Bekle(1);
        WebElement passW5= driver.findElement(By.xpath("//input[@id='Password']"));
        passW5.sendKeys("untesterTester1256");

        MyFunc.Bekle(1);
        WebElement LogggIn5=driver.findElement(By.xpath("//input[@value='Log in']"));
        LogggIn5.click();

        MyFunc.Bekle(3);
        driver.quit();
    }

}
