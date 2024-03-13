import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0701_Muharrem extends BaseDriver {

    //1. Web tarayıcısını açın ve "demowebshop.tricentis.com" adresine gidin.
    //2. Eğer kullanıcı oturumu açık değilse, oturum açın (giriş yapın).
    //3. Anasayfada "Do you like nopCommerce?" sorusuna yanıtlayın.
    //4. Oylama için "Excellent" (Mükemmel) seçeneğini seçin. 5. Oy vermek için ilgili düğmeye tıklayın.

    @Test
    public void Test0701(){


        //1. Web tarayıcısını açın ve "demowebshop.tricentis.com" adresine gidin.
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));


    }

}
