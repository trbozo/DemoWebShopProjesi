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

public class TC_0701_Muharrem extends BaseDriver {

    @Test
    public void Test701(){


        //1. Web tarayıcısını açın ve "demowebshop.tricentis.com" adresine gidin.
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        //2. Eğer kullanıcı oturumu açık değilse, oturum açın (giriş yapın).
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

        //3. Anasayfada "Do you like nopCommerce?" sorusuna yanıtlayın.
        //4. Oylama için "Excellent" (Mükemmel) seçeneğini seçin. 5. Oy vermek için ilgili düğmeye tıklayın.

        WebElement pollFind= driver.findElement(By.xpath("//input[@id=\"pollanswers-1\"]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(pollFind)
                .click()
                .build()
                .perform();

        WebElement voteClick= driver.findElement(By.xpath("//input[@id=\"vote-poll-1\"]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(voteClick)
                .click()
                .build()
                .perform();


        //5. Oy vermek için Vote ye tıklayın.
        WebElement voteMsg= driver.findElement(By.xpath("//*[@class=\"poll-total-votes\"]"));
        MyFunc.Bekle(2);
        Assert.assertTrue("Only registered users can vote", voteMsg.getText().contains("vote(s)..."));

        BekleKapat();



    }

}
