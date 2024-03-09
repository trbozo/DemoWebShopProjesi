import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TC_0101 extends BaseDriver {

    @Test
    public void _US_201(){

        driver.get("https://demowebshop.tricentis.com/");

        // List<WebElement> consent=driver.findElements(By.xpath("//*[text()='Tümünü Kabul Et']"));
        // if(consent.size()>0)
        //     consent.get(0).click();


        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        MyFunc.Bekle(3);

        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        MyFunc.Bekle(3);

        WebElement Firstname=driver.findElement(By.xpath("//input[@id='FirstName']"));
        Firstname.sendKeys("test");
        MyFunc.Bekle(3);

        WebElement lastname=driver.findElement(By.xpath("//input[@id='LastName']"));
        lastname.sendKeys("Tester");
        MyFunc.Bekle(3);

        WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("test123@gmail.com");

        MyFunc.Bekle(3);
        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Test123");

        MyFunc.Bekle(3);
        WebElement Confirmpassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        Confirmpassword.sendKeys("Test123");

        MyFunc.Bekle(3);
        WebElement register1=driver.findElement(By.xpath("//input[@id='register-button']"));
        register1.click();

        BekleKapat();



    }
}

