package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;
import java.util.List;

public class US206_TC01 extends BaseDriver {
    @Test
    public void orderTest() {

        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "fastest90@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Qwerty12");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();

        List<WebElement> itemTitlesList = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
        for (WebElement webElement : itemTitlesList) {
            if (webElement.getText().contains("14.1-inch Laptop")) {
                webElement.click();
                break;
            }
        }

        WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='button'][@value='Add to cart'])[1]")));
        addToCartBtn.click();

        WebElement successMsjAdToCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        Assert.assertEquals(successMsjAdToCard.getText(), "The product has been added to your shopping cart");

        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']/a"));
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        shoppingCart.click();

        WebElement country = driver.findElement(By.id("CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("1");

        WebElement state = driver.findElement(By.id("StateProvinceId"));
        Select selectState = new Select(state);
        selectState.selectByValue("9");

        WebElement zipCode = driver.findElement(By.id("ZipPostalCode"));
        zipCode.clear();
        zipCode.sendKeys("44100");

        WebElement terms = driver.findElement(By.id("termsofservice"));
        terms.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement newAddressOption = driver.findElement(By.xpath("//select/option[text()='New Address']"));
        newAddressOption.click();

        WebElement countryDropdown = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Turkey");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Istanbul");

        WebElement address = driver.findElement(By.id("BillingNewAddress_Address1"));
        address.sendKeys("Moda Kadikoy");

        WebElement zipPostalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipPostalCode.sendKeys("81300");

        WebElement phone = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phone.sendKeys("5357888990");

        WebElement continueBilling = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Billing.save()\"]")));
        continueBilling.click();

        WebElement continueShipping = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Shipping.save()\"]")));
        continueShipping.click();

        WebElement continueShippingMethod = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ShippingMethod.save()\"]")));
        continueShippingMethod.click();

        // Payment method has been set as credit card.
        WebElement creditCard = wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_2")));
        creditCard.click();
        WebElement continuePaymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentMethod.save()\"]")));
        continuePaymentMethod.click();
        WebElement cardholderName = driver.findElement(By.id("CardholderName"));
        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        WebElement cardCode = driver.findElement(By.id("CardCode"));
        cardholderName.sendKeys("Faster Tester");
        cardNumber.sendKeys("4242 4242 4242 4242");
        cardCode.sendKeys("123");
        // Expire Date.
        WebElement expiryMonthDropdown = driver.findElement(By.id("ExpireMonth"));
        WebElement expiryYearDropdown = driver.findElement(By.id("ExpireYear"));
        Select expiryMonthSelect = new Select(expiryMonthDropdown);
        Select expiryYearSelect = new Select(expiryYearDropdown);
        expiryMonthSelect.selectByValue("1");
        expiryYearSelect.selectByValue("2032");

        WebElement continuePaymentInfo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentInfo.save()\"]")));
        continuePaymentInfo.click();

        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ConfirmOrder.save()\"]")));
        confirmBtn.click();
        WebElement successMessage = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue(successMessage.getText().contains("successfully"));

        WebElement orderDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Click here for order details.']")));
        orderDetails.click();
        WebElement orderText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".order-number")));
        String orderNumber = orderText.getText().substring(7);
        Assert.assertTrue(driver.getCurrentUrl().contains(orderNumber));

        WebElement logOutBtn = driver.findElement(By.className("ico-logout"));
        logOutBtn.click();

        delayQuit();
    }
}