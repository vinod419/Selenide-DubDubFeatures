package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Speaker {

    SelenideElement DROPDOWN = $(byXpath("//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]//div[1]//div[2]//*[name()='svg']"));
    SelenideElement EDITVOICE = $(byXpath("//div[normalize-space()='Edit voice']"));
    SelenideElement SELECTCARD = $(byXpath("//span[contains(@class,'checkmarkVoiceSelection')]"));

    public void speaker() throws InterruptedException {
        Thread.sleep(5000);
        DROPDOWN.shouldBe(visible).click();
        EDITVOICE.shouldBe(visible).click();
        Thread.sleep(3000);
        SELECTCARD.shouldBe(visible).click();
    }

}

