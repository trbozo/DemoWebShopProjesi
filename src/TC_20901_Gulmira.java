import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_20901_Gulmira extends BaseDriver {
    @Test
    public void test9(){
    //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com".
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
    //Step 2. If the user session is not open, log in (login).
        WebElement loginLink= driver.findElement(By.xpath("//*[text()='Log in']"));
        Actions aksiyonlar=new Actions(driver); //// web sayfası aksiyonlara açıldı.

        Action aksiyon= aksiyonlar.moveToElement(loginLink).click().build();
        MyFunc.Bekle(3);
        aksiyon.perform();

        WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(email)
                .click()
                .sendKeys("ahmet@mail.ru")
                .build()
                .perform();

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(password)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("hmet123")
                .build()
                .perform();

        WebElement logginButton= driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(logginButton)
                .click()
                .build()
                .perform();

        //Step 3. Navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
        WebElement myAccount= driver.findElement(By.xpath("(//*[@class='account'])[1]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(myAccount)
                .click()
                .build()
                .perform();
        //Step 4. View your orders by clicking on the "Orders" (Orders) link.
        WebElement orders= driver.findElement(By.xpath("(//*[@href='/customer/orders'])[1]"));
        MyFunc.Bekle(3);
        //wait.until(ExpectedConditions.invisibilityOf(orders));

        new Actions(driver)
                .moveToElement(orders)
                .click()
                .build()
                .perform();



        //Step 5. Click the "Details" link of the order (or Enson order) you want to view.
        //Step 6. Download and view the invoice by clicking on the PDF Invioice link.

        BekleKapat();
    }
}
