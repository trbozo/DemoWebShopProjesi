package US106;
import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US106 extends BaseDriver {
    @Test
    public void Order() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/"); //website açıldı
        MyFunc.Bekle(2);

        Actions aksiyonlar=new Actions(driver); //web sayfası aksiyonlara açıldı

        WebElement LogIn=driver.findElement(By.linkText("Log in")); //log in buton tıklandı
        Action aksiyon1=aksiyonlar.moveToElement(LogIn).click().build();
        aksiyon1.perform();

        WebElement email=driver.findElement(By.id("Email")); //email adresi girildi
        email.sendKeys("elcnburak@hotmail.com");

        WebElement password=driver.findElement(By.id("Password")); //şifre girildi
        password.sendKeys("Haziran4052**");

        WebElement LogInBtn=driver.findElement(By.xpath("//input[@value='Log in']")); //log in buton tıklandı
        Action aksiyon2=aksiyonlar.moveToElement(LogInBtn).click().build();
        aksiyon2.perform();

        WebElement computersLink=driver.findElement(By.linkText("COMPUTERS")); //computers link tıklandı
        Action aksiyon3=aksiyonlar.moveToElement(computersLink).click().build();
        aksiyon3.perform();
        MyFunc.Bekle(1);

        WebElement notebookLink=driver.findElement(By.linkText("Notebooks")); //notebook link tıklandı
        Action aksiyon4=aksiyonlar.moveToElement(notebookLink).click().build();
        aksiyon4.perform();
        MyFunc.Bekle(1);

        WebElement inchLaptopLink=driver.findElement(By.linkText("14.1-inch Laptop")); //notebook seçildi,tıklandı
        Action aksiyon5=aksiyonlar.moveToElement(inchLaptopLink).click().build();
        aksiyon5.perform();
        MyFunc.Bekle(1);

        WebElement AddtoCart=driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']")); //sepete eklendi
        Action aksiyon6=aksiyonlar.moveToElement(AddtoCart).click().build();
        aksiyon6.perform();
        MyFunc.Bekle(2);

        WebElement AddtoCartLink=driver.findElement(By.linkText("Shopping cart")); //sepete gidildi
        Action aksiyon7=aksiyonlar.moveToElement(AddtoCartLink).click().build();
        aksiyon7.perform();
        MyFunc.Bekle(2);

        WebElement country=driver.findElement(By.id("CountryId")); // kargo bilgileri için ülke seçildi
        Select countrySelect = new Select(country);
        String countryToSelect = "United States";
        countrySelect.selectByVisibleText(countryToSelect);
        MyFunc.Bekle(2);

        WebElement state=driver.findElement(By.id("StateProvinceId")); // kargo bilgileri için bölge seçildi
        Select stateSelect = new Select(state);
        String stateToSelect = "Alabama"; //
        stateSelect.selectByVisibleText(stateToSelect);
        MyFunc.Bekle(2);

        WebElement estimateShipBtn=driver.findElement(By.name("estimateshipping"));// estitame shipping buton tıklandı
        Action aksiyon8=aksiyonlar.moveToElement(estimateShipBtn).click().build();
        aksiyon8.perform();
        MyFunc.Bekle(2);

        WebElement TermCheck=driver.findElement(By.id("termsofservice")); //term koşulları tıklandı
        Action aksiyon9=aksiyonlar.moveToElement(TermCheck).click().build();
        aksiyon9.perform();

        WebElement checkOut=driver.findElement(By.id("checkout")); //checkout buton tıklandı
        Action aksiyon10=aksiyonlar.moveToElement(checkOut).click().build();
        aksiyon10.perform();

        WebElement buton1=driver.findElement(By.id("billing-buttons-container"));
        Action aksiyon11=aksiyonlar.moveToElement(buton1).click().build(); //buton tıklan
        aksiyon11.perform();

        WebElement Billcountry=driver.findElement(By.id("BillingNewAddress_CountryId"));//bill country seçildi
        Select BillcountrySelect=new Select(Billcountry);
        String BillcountryToSelect="United States";
        BillcountrySelect.selectByVisibleText(BillcountryToSelect);

        WebElement Billstate=driver.findElement(By.id("BillingNewAddress_StateProvinceId"));//bill state seçildi
        Select BillstateSelect=new Select(Billstate);
        String BillstateToSelect="Alabama";
        BillstateSelect.selectByVisibleText(BillstateToSelect);

        WebElement city=driver.findElement(By.id("BillingNewAddress_City")); //city girildi
        city.sendKeys("Visconsin");

        WebElement adres1=driver.findElement(By.id("BillingNewAddress_Address1")); //adres1 girildi
        adres1.sendKeys("Techno Street");

        WebElement adres2=driver.findElement(By.id("BillingNewAddress_Address2")); //adres2 girildi
        adres2.sendKeys("Study Avenue NO:25");

        WebElement zipCode=driver.findElement(By.id("BillingNewAddress_ZipPostalCode")); //zipcode girildi
        zipCode.sendKeys("123456");

        WebElement phone=driver.findElement(By.id("BillingNewAddress_PhoneNumber")); // phone number girildi
        phone.sendKeys("1555222333");

        WebElement continueButton = driver.findElement(By.cssSelector("#billing-buttons-container input[title='Continue']"));
        Action aksiyon12=aksiyonlar.moveToElement(continueButton).click().build(); //buton tıklan
        aksiyon12.perform();

       WebElement shipAdress=driver.findElement(By.id("shipping-address-select"));// gönderim adresi girildi
       Select select = new Select(shipAdress);
       select.selectByVisibleText("elcin burak, Techno Street, Visconsin 123456, United States");

        Thread.sleep(3000);

        WebElement continueButton0 = driver.findElement(By.cssSelector("#shipping-buttons-container input[title='Continue']"));
        continueButton0.click();//buton tıklandı

        WebElement ground=driver.findElement(By.id("shippingoption_0"));
        ground.click();//taşıma yolu ücretiseçildi

        WebElement continueButton4 = driver.findElement(By.cssSelector("#shipping-method-buttons-container input.shipping-method-next-step-button"));
        continueButton4.click();//buton tıklandı.

        WebElement creditCardRadioButton = driver.findElement(By.id("paymentmethod_2"));// ödeme yöntemi seçildi.
        creditCardRadioButton.click();
        WebElement continueButton5 = driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @value='Continue']"));
        continueButton5.click();

        WebElement creditCardType=driver.findElement(By.id("CreditCardType")); //credit cart türü visa seçildi
        Select cartVisaSelect=new Select(creditCardType);
        String cartVisaToSelect="Visa";
        cartVisaSelect.selectByVisibleText(cartVisaToSelect);

        WebElement creditHolderName=driver.findElement(By.id("CardholderName")); // kart sahibine ait ad ve soyad girildi.
        creditHolderName.sendKeys("Elcin Burak");

        WebElement crediCardNo=driver.findElement(By.id("CardNumber"));//card numara girildi.
        crediCardNo.sendKeys("1111 2222 3333 4444");

        WebElement exDate=driver.findElement(By.id("ExpireMonth"));//card son kullanma ayı girildi
        Select exDateSelect=new Select(exDate);
        String exDatetoSelect="01";
        exDateSelect.selectByVisibleText(exDatetoSelect);

        WebElement exYear=driver.findElement(By.id("ExpireYear"));//card son kullanma yılı girildi.
        Select exYearSelect=new Select(exYear);
        String exYeartoSelect="2026";
        exYearSelect.selectByVisibleText(exYeartoSelect);

        WebElement cardCode=driver.findElement(By.id("CardCode"));// card kodu girildi.
        cardCode.sendKeys("123");

        WebElement continue3=driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        continue3.click();

        List<WebElement> urunler = driver.findElements(By.cssSelector("span.product-unit-price"));//ürünlerin fiyatları için liste oluşturuldu.

        double urunUcretToplam = 0;

        for (WebElement e : urunler) {
            System.out.println("e.getText() = " + e.getText());
            String StrUrunFiyat = e.getText().replaceAll("[^0-9,.]", "");
            double urunFiyat = Double.parseDouble(StrUrunFiyat);
            urunUcretToplam = urunUcretToplam + urunFiyat;
        }
        System.out.println("urunUcretToplam = " + urunUcretToplam);

        WebElement itemTotalElement = driver.findElement(By.cssSelector("td.cart-total-right span.product-price"));
        String strItemTotal = itemTotalElement.getText().replaceAll("[^0-9,.]","");
        double ItemTotal=Double.parseDouble(strItemTotal);
        System.out.println("ItemTotal = " + ItemTotal);

        Assert.assertTrue("Rakamlar eşit değil", urunUcretToplam==ItemTotal);// total ücret ile listedeki ürünlerin fiyatlarının toplamı karşılaştırıldı.

        WebElement confirmButton = driver.findElement(By.cssSelector("input.confirm-order-next-step-button"));
        confirmButton.click();// sipariş onaylandı.

        WebElement successMessage = driver.findElement(By.cssSelector("div.title > strong"));
        String messageText = successMessage.getText();
        System.out.println("Success message: " + messageText);

        WebElement orderNumberElement = driver.findElement(By.xpath("//li[contains(text(), 'Order number')]"));
        String orderNumber = orderNumberElement.getText();

        System.out.println("Order number: " + orderNumber);// order numarası alındı.

        WebElement finish=driver.findElement(By.cssSelector(".button-2.order-completed-continue-button"));//bitti.
        finish.click();

        BekleKapat();

    }

}

