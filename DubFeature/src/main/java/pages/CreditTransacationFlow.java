package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CreditTransacationFlow {

    SelenideElement SIGNUPFORFREE = $(byXpath("//button[normalize-space()='Signup for free']"));
    SelenideElement FULLNAME = $(byXpath("//div[2]//form[1]//div[3]//div[1]//input[1]"));
    SelenideElement EMAIL = $(byXpath("//div[2]//form[1]//div[3]//div[2]//input[1]"));
    SelenideElement PASSWORD = $(byXpath("//div[2]//form[1]//div[3]//div[3]//input[1]"));
    SelenideElement SIGNUP = $(byXpath("//button[normalize-space()='Signup']"));
    SelenideElement REMINDMELATER = $(byXpath("//button[normalize-space()='Remind me later']"));
    SelenideElement ADDNEWVIDEO =$(byXpath("//button[normalize-space()='+ Add new video']"));
    SelenideElement ADDNEW = $(byXpath("//div[@type='button']//img"));
    SelenideElement TITLE = $(byXpath("//input[@id='newProject']"));
    SelenideElement ADD = $(byXpath("//button[normalize-space()='Add']"));
    SelenideElement SELECT = $(byXpath("//div[@id='mui-component-select-project_industry']"));
    SelenideElement OPTION = $(byXpath("//span[normalize-space()='Content creators']"));
    SelenideElement OTT = $(byXpath("//div//div//div//div//div//div//div//div//div//div//div[1]//label[1]//span[1]"));
    SelenideElement NEXT = $(byXpath("//div[contains(@class,'cursor-pointer hover:bg-hoverPurple')]"));
    SelenideElement UPLOADFILE = $(byXpath("//label[1]"));
    SelenideElement NEXT2 = $(byXpath("//span[@class='pl-1 text-white text-20px leading-9']"));
    SelenideElement SOURCELNG = $(byXpath("(//input[@id='combo-box-demo'])[1]"));
    SelenideElement SELECTLNG = $(byXpath("//li[@id='combo-box-demo-option-5']"));
    SelenideElement TARGETLNG = $(byXpath("(//input[@id='combo-box-demo'])[2]"));
    SelenideElement LNG1 = $(byXpath("//li[@id='combo-box-demo-option-1']"));
    SelenideElement LNG2 = $(byXpath("//li[@id='combo-box-demo-option-2']"));
    SelenideElement LNG3 = $(byXpath("//li[@id='combo-box-demo-option-3']"));
    SelenideElement SUBMIT =$(byXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]"));
    SelenideElement REMAININGCREDITS = $(byXpath("//span[@class='text-16px leading-5 text-white ml-2']"));
    SelenideElement SYMBOl = $(byXpath("//div[@class='flex-shrink m-2 cursor-pointer']//img")) ;

    @Test
    public void signUp() throws InterruptedException {
        SIGNUPFORFREE.shouldBe(visible).click();
        FULLNAME.shouldBe(visible).setValue("Vinod K");


        Random rand = new Random();
        String domain = "@dubdub.ai";
        String email = null;
        int randomNum;

        for (int i = 0; i < 1; i++) {
            randomNum = rand.nextInt(1000);
            email = "user" + randomNum + domain;
            System.out.println(email);
        }
        EMAIL.shouldBe(visible).setValue(email);
        PASSWORD.shouldBe(visible).setValue("Vinod@123");
        SIGNUP.shouldBe(visible).click();
    }

    @Test
    public void homePage() throws InterruptedException {
        //
        Thread.sleep(3000);
        REMINDMELATER.shouldBe(visible).click();
        ADDNEWVIDEO.shouldBe(visible).click();
    }

    @Test
    public void createProject()  {
        ADDNEW.shouldBe(visible).click();
        TITLE.shouldBe(visible).setValue("DemoForCreditTranscation");
        ADD.shouldBe(visible).click();
        SELECT.shouldBe(visible).pressEnter();
        OPTION.shouldBe(visible).click();
        OTT.shouldBe(visible).click();
        NEXT.shouldBe(visible).click();
    }

    @Test
    public void uploadFile() throws InterruptedException, AWTException {
        //UPLOADFILE.shouldBe(visible).sendKeys("C:\\Users\\vinod\\IdeaProjects\\DubFeature\\VideoFile\\video-1234.mp4");
        UPLOADFILE.shouldBe(visible).click();
        Thread.sleep(7000);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("C:\\Users\\vinod\\IdeaProjects\\DubFeature\\VideoFile\\video-1234.mp4");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(30000);
        NEXT2.shouldBe(visible).click();

    }

    @Test
    public void selectLanguage() throws InterruptedException {
        SOURCELNG.shouldBe(visible).click();
        SELECTLNG.shouldBe(visible).click();
        TARGETLNG.shouldBe(visible).click();
        LNG1.shouldBe(visible).click();
        TARGETLNG.shouldBe(visible).click();
        LNG2.shouldBe(visible).click();
        TARGETLNG.shouldBe(visible).click();
        LNG3.shouldBe(visible).click();
        SUBMIT.shouldBe(visible).click();
        Thread.sleep(5000);
        String credits = REMAININGCREDITS.getText();
        Assert.assertEquals(credits, "10 credits","Credits not successfully deducted");

    }

}
