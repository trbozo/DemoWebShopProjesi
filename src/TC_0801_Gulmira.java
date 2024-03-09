import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0801_Gulmira extends BaseDriver {
    @Test
    public void Test801(){
        driver.get("https://demowebshop.tricentis.com/");
        //wait.until(ExpectedConditions.urlToBe("Demowebshop.tricentis.com"));
        MyFunc.Bekle(3);



        BekleKapat();
    }
}
