import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class TC_0301 extends BaseDriver {
        @Test

        public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();
            driver.get("http://demowebshop.tricentis.com");


            WebElement loginLink = driver.findElement(By.className("ico-login"));
            loginLink.click();


            WebElement usernameInput = driver.findElement(By.id("Email"));
            WebElement passwordInput = driver.findElement(By.id("Password"));
            WebElement loginButton = driver.findElement(By.className("login-button"));

            usernameInput.sendKeys("techno.team12@gmail.com");
            passwordInput.sendKeys("Pass1234");
            loginButton.click();


            WebElement loggedInUserName = driver.findElement(By.className("account"));
            if (loggedInUserName.isDisplayed()) {
                System.out.println("3. Adım: Kullanıcı adı göründü - Test başarılı!");
            } else {
                System.out.println("3. Adım: Kullanıcı adı görünmedi - Test başarısız!");
            }

            WebElement logoutLink = driver.findElement(By.className("ico-logout"));
            logoutLink.click();

            // 5. Adım: Çıkış yapıldığını doğrulama
            WebElement loginLinkAfterLogout = driver.findElement(By.className("ico-login"));
            if (loginLinkAfterLogout.isDisplayed()) {
                System.out.println("5. Adım: Oturum başarıyla kapatıldı - Test başarılı!");
            } else {
                System.out.println("5. Adım: Oturum kapatılamadı - Test başarısız!");
            }


            driver.quit();
        }
    }














