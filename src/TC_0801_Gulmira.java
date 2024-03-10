import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0801_Gulmira extends BaseDriver {
    @Test
    public void Test801(){
        //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com ".
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        //Step 2. If the user session is not open, log in (log in).
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

        //Step 3. In the homepage, click "14.1-inin Laptop" under "Notebook" from the "Computers" menu.

        WebElement computers=driver.findElement(By.xpath("(//a[contains(@href,'/computers')])[1]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(computers)
                .build()
                .perform();
        MyFunc.Bekle(3);

        WebElement notebooks= driver.findElement(By.xpath("(//a[contains(@href,'/notebooks')])[1]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(notebooks)
                .click()
                .build()
                .perform();

        WebElement notebook14Inch= driver.findElement(By.xpath("//*[@class='product-title']/a"));
               new Actions(driver)
                .moveToElement(notebook14Inch)
                .click()
                .build()
                .perform();

        MyFunc.Bekle(3);
                new Actions(driver).
                scrollByAmount(0,500).
                build().
                perform();

        //Step 4. On the product page, click the "Add to Cart" button to add the product to the basket.
        WebElement addToCart= driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(addToCart)
                .click()
                .build()
                .perform();

//        5. Click the "Shopping Cart" button to navigate to your
//        basket.
//        6. Click the "Apply Coupon" button (Use Coupon) (click on
//        the Coupon Code If you do not enter the code).
//        7. Verify that there is no coupon code to be used.
//        8.
//        9. Verify that there is no Gift Card to be used.
//        10. Fill the necessary information for the cargo details:
//        11. Choose a country and state.
//        12. Accept the conditions.
//        13. Click the "Checkout" (payment) button to navigate to the
//        payment page.
//        14. Fill the payment information and confirm the order.
//        15 "Your order has been successfully processed!" Verify
//        that the message is displayed.



        BekleKapat();
    }
}
