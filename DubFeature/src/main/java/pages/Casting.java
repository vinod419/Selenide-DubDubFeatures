package pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Casting {

     SelenideElement DONE = $(byXpath("//tr[@id='collapseExample3']//div[contains(@class,'flex w-24 flex-row pt-1 pb-1 rounded pl-2 pr-2 bg-greenShade text-success text-16px font-normal font-poppins')][normalize-space()='Done']"));
     SelenideElement EDIT = $(byXpath("//div[contains(@class,'pt-3 pb-3 flex flex-row p-2')]"));
     SelenideElement CHAR = $(byXpath("(//div[@class='flex flex-row justify-between w-full'])[1]"));
     SelenideElement ADDSPEAKER = $(byXpath("//div[normalize-space()='Add Speaker']"));
     SelenideElement NAME = $(byXpath("//input[contains(@placeholder,'Enter the name')]"));
     SelenideElement AGE = $(byXpath("(//div[@role='button'])[1]"));
     SelenideElement YOUNGADULT = $(byXpath("//span[normalize-space()='Young Adult']"));
     SelenideElement GENDER = $(byXpath("(//div[contains(@role,'button')])[2]"));
     SelenideElement MALE = $(byXpath("//span[normalize-space()='Male']"));
     SelenideElement SAVE = $(byXpath("//button[normalize-space()='Save']"));
     SelenideElement CARD = $(byXpath("(//div[contains(@class,'m-auto')])[2]"));
     SelenideElement READY = $(byText("Bring it on! I'm ready"));
     SelenideElement SELECTVOICE = $(byXpath("//button[normalize-space()='Select Voice']"));
     SelenideElement SUBMIT = $(byXpath("//button[normalize-space()='Submit']"));
     SelenideElement CHANGESPEAKER = $(byXpath("//div[normalize-space()='Change speaker']"));
     SelenideElement AUTO = $(byCssSelector("div[data-tip='AUTO']"));
     SelenideElement FINALSAVE = $(byCssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > nav:nth-child(1) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)"));
     SelenideElement RERENDER = $(byXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/nav[1]/div[3]/div[1]/button[1]/div[1]"));
     @Test
     public void EnterTheProject() throws InterruptedException {
         Thread.sleep(7000);
         DONE.shouldBe(visible).click();
         EDIT.shouldBe(visible).click();
         Thread.sleep(3000);
     }
    @Test
     public void addSpeaker() throws InterruptedException {
        READY.shouldBe(visible).click();
        CHAR.shouldBe(visible).click();
        ADDSPEAKER.shouldBe(visible).click();
        NAME.shouldBe(visible).setValue("AUTO");
        AGE.shouldBe(visible).click();
        YOUNGADULT.shouldBe(visible).click();
        GENDER.shouldBe(visible).click();
        MALE.shouldBe(visible).click();
        Thread.sleep(3000);
        SAVE.shouldBe(visible).click();
        Thread.sleep(2000);
        SELECTVOICE.shouldBe(visible).click();
        Thread.sleep(3000);
        CARD.shouldBe(visible).click();
        Thread.sleep(2000);
        SUBMIT.shouldBe(visible).click();

    }
    @Test
    public void changeSpeaker() throws InterruptedException {
         CHAR.shouldBe(visible).click();
         Thread.sleep(2000);
         CHANGESPEAKER.shouldBe(visible).click();
         Thread.sleep(2000);
         AUTO.shouldBe(visible).click();
         Thread.sleep(3000);
         FINALSAVE.shouldBe(visible).click();
         Thread.sleep(3000);
         RERENDER.shouldBe(visible).click();
         Thread.sleep(10000);
    }

}
