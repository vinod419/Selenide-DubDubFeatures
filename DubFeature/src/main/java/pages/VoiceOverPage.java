package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class VoiceOverPage {
    SelenideElement VOICEOVER = $(byXpath("//a[normalize-space()='Voiceover']"));
    SelenideElement CREATEVOICEOVER = $(byXpath("//div[contains(@class,'pt-2')]"));
    SelenideElement ADDNEW = $(byText("Add new"));
    SelenideElement PROJECTNAME = $(byXpath("//input[@id='newProject']"));
    SelenideElement ADD = $(byXpath("//button[normalize-space()='Add']"));
    SelenideElement LANGUAGE = $(byXpath("//input[@id='combo-box-demo']"));
    SelenideElement KANNADA = $(byXpath("//li[@id='combo-box-demo-option-5']"));
    SelenideElement USECASE = $(byText("Audio book"));
    SelenideElement CREATEVOICEOVERBUTTON = $(byXpath("//button[normalize-space()='Create voiceover']"));



    public void CreateVoiceOver() throws InterruptedException {
        Thread.sleep(3000);
        VOICEOVER.shouldBe(visible).click();
        Thread.sleep(5000);
        CREATEVOICEOVER.shouldBe(visible).click();
        ADDNEW.shouldBe(visible).click();
        PROJECTNAME.shouldBe(visible).setValue("Automation");
        ADD.shouldBe(visible).click();
        LANGUAGE.shouldBe(visible).click();
        KANNADA.shouldBe(visible).click();
        USECASE.shouldBe(visible).click();
        CREATEVOICEOVERBUTTON.shouldBe(visible).click();


    }
}
