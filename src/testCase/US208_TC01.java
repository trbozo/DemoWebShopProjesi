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

public class US208_TC01 extends BaseDriver {
    @Test
    public void orderTestNegative() {

        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        if (!driver.findElement(By.cssSelector(".ico-login")).isDisplayed()) {
            System.out.println("You are already logged out");
            return;
        }

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

        WebElement addToCartBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='button'][@value='Add to cart'])[1]")));
        addToCartBtn.click();

        WebElement successMsjAdToCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        Assert.assertEquals(successMsjAdToCard.getText(), "The product has been added to your shopping cart");

        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']/a"));
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        shoppingCart.click();

        WebElement applyCoupon = driver.findElement(By.cssSelector("[class='button-2 apply-discount-coupon-code-button'"));
        wait.until(ExpectedConditions.visibilityOf(applyCoupon));
        applyCoupon.click();

        // Cehckpoint
        WebElement applyCouponMessage = driver.findElement(By.cssSelector("[class='message']"));
        Assert.assertEquals("The coupon code you entered couldn't be applied to your order", applyCouponMessage.getText());

        WebElement addGiftCard = driver.findElement(By.cssSelector("[class='button-2 apply-gift-card-coupon-code-button'"));
        wait.until(ExpectedConditions.visibilityOf(addGiftCard));
        addGiftCard.click();

        WebElement addGiftCardMessage = driver.findElement(By.cssSelector("[class='message']"));
        Assert.assertEquals("The coupon code you entered couldn't be applied to your order", addGiftCardMessage.getText());

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

        WebElement newAddress = driver.findElement(By.xpath("//*[text()='New Address']"));
        newAddress.click();

        WebElement country1 = driver.findElement(By.id("BillingNewAddress_CountryId"));

        Select selectCountry1 = new Select(country1);
        selectCountry1.selectByValue("1");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("NewYork");

        WebElement address = driver.findElement(By.id("BillingNewAddress_Address1"));
        address.sendKeys("NewYork 2");

        WebElement zipPostalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipPostalCode.sendKeys("44100");

        WebElement phone = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phone.sendKeys("1856745963");

        WebElement continue1 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Billing.save()\"]")));
        continue1.click();

        WebElement continue2 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Shipping.save()\"]")));
        continue2.click();

        WebElement continue3 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ShippingMethod.save()\"]")));
        continue3.click();

        WebElement continue4 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentMethod.save()\"]")));
        continue4.click();

        WebElement continue5 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentInfo.save()\"]")));
        continue5.click();

        WebElement confirmBtn =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ConfirmOrder.save()\"]")));
        confirmBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue(successMessage.getText().contains("successfully"));

        WebElement logOutBtn = driver.findElement(By.className("ico-logout"));
        logOutBtn.click();

        delayQuit();

    }
}
