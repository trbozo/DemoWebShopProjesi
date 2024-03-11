import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_20901_Gulmira extends BaseDriver {
    @Test
    public void test9(){
    //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com".
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
    //Step 2. If the user session is not open, log in (login).

    //Step 3. Navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
    //Step 4. View your orders by clicking on the "Orders" (Orders) link.
    //Step 5. Click the "Details" link of the order (or Enson order) you want to view.
    //Step 6. Download and view the invoice by clicking on the PDF Invioice link.
    }
}
