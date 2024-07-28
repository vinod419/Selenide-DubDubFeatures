package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddCredits {

    SelenideElement SETTING = $(byXpath("//a[normalize-space()='Settings']"));
    SelenideElement ADDCREDITS = $(byXpath("//button[normalize-space()='Add credits']"));
    SelenideElement PURCHASE = $(byXpath("//button[normalize-space()='Purchase']"));
    SelenideElement CARDNO = $(byXpath("//input[@id='cardNumber']"));
    SelenideElement CARDRXPIRY = $(byXpath("//input[@id='cardExpiry']"));
    SelenideElement CVC = $(byXpath("//input[@id='cardCvc']"));
    SelenideElement CARDNAME= $(byXpath("//input[@id='billingName']"));
    SelenideElement COUNTRY= $(byXpath("//select[@id='billingCountry']"));
    SelenideElement ADDRESLINE = $(byXpath("//input[@id='billingAddressLine1']"));
    SelenideElement CITY = $(byXpath("//input[@id='billingLocality']"));
    SelenideElement PIN = $(byXpath("//input[@id='billingPostalCode']"));
    SelenideElement STATE = $(byXpath("//select[@id='billingAdministrativeArea']"));
    SelenideElement PAY = $(byXpath("//div[@class='SubmitButton-IconContainer']"));
    SelenideElement GOHOME= $(byXpath("//a[normalize-space()='Go home']"));
    SelenideElement REMAININGCREDITS = $(byXpath("//span[@class='text-16px leading-5 text-white ml-2']"));

    @Test
    public void addCredits() throws InterruptedException {
        SETTING.shouldBe(visible).click();
        ADDCREDITS.shouldBe(visible).click();
        Thread.sleep(3000);
        PURCHASE.shouldBe(visible).click();
        Thread.sleep(15000);
        CARDNO.shouldBe(visible).setValue("4242424242424242");
        CARDRXPIRY.shouldBe(visible).setValue("03/26");
        CVC.shouldBe(visible).setValue("123");
        CARDNAME.shouldBe(visible).setValue("Vinod");
        COUNTRY.shouldBe(visible).selectOptionByValue("IN");
        ADDRESLINE.shouldBe(visible).setValue("123 William Street").pressEnter();
        CITY.shouldBe(visible).setValue("Mysore");
        PIN.shouldBe(visible).setValue("570007");
        STATE.shouldBe(visible).selectOptionByValue("Karnataka");
        PAY.shouldBe(visible).click();
        Thread.sleep(5000);
        GOHOME.shouldBe(visible).click();
        Thread.sleep(5000);
        String credits = REMAININGCREDITS.getText();
        Assert.assertEquals(credits, "110 credits","Credits not successfully added");
        Thread.sleep(3000);



    }
}
