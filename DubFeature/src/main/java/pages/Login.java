package pages;

import Browser.BaseSetup;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class Login extends BaseSetup {
    SelenideElement EMAIL = $(byXpath("//input[@id='email']"));
    SelenideElement PASSWORD = $(byXpath("//input[@id='password']"));
    SelenideElement LOGIN = $(byXpath("//button[normalize-space()='Login']"));
    SelenideElement SETTING =$(byXpath("//a[normalize-space()='Settings']"));
    SelenideElement LOGOUT = $(byXpath("//button[normalize-space()='Logout']"));
    SelenideElement LOGINPAGE = $(byText("Login to dubdub.ai"));


    @Test
    public void loginForAll() {
        EMAIL.shouldBe(visible).setValue("vinod@dubdub.ai");
        PASSWORD.shouldBe(visible).setValue("Vinod@123");
        LOGIN.shouldBe(visible).click();
    }

    public void email( String email, String password){

        EMAIL.shouldBe(visible).setValue(email);
        PASSWORD.shouldBe(visible).setValue(password);
        LOGIN.shouldBe(visible).click();
        String Actul = EMAIL.getAttribute("value");
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result = Actul.matches(regex);
        if (result) {
            System.out.println("Given email-id is valid");
            //reportPass(" valid Email is accepted ");
        } else {
            System.out.println("Given email-id is not valid");
           // reportPass("Invalid Email and doesn't throw Eror message");

        }
        refresh();

    }

    public void password( String email, String password) {
       // logger = report.createTest("Password validation");

        EMAIL.shouldBe(visible).setValue(email);
        PASSWORD.shouldBe(visible).setValue(password);
        LOGIN.shouldBe(visible).click();
        String Actul = PASSWORD.getAttribute("value");
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        boolean result = Actul.matches(regex);

        System.out.println(result);

        if (result) {
           // reportPass(" valid Password is accepted ");
            System.out.println("Given password is valid");
        } else {

          //  reportPass("Invalid Password and doesn't throw Eror message");
            System.out.println("Given password is not valid");

        }
        refresh();
    }

    @Test
    public void login(String scenario, String email, String password) throws InterruptedException {

        //logger = report.createTest("Submit button validation");
        EMAIL.shouldBe(visible).setValue(email);
        PASSWORD.shouldBe(visible).setValue(password);
        LOGIN.shouldBe(visible).click();

        if(scenario.equals("BothCorrect")) {
            String page = title();
            Assert.assertEquals(page,"dubdub.ai");
            //reportPass("with Correct credential it's  showed any output");
            SETTING.shouldBe(visible).click();
            LOGOUT.shouldBe(visible).click();


        }
        else if(scenario.equals("Bothwrong")) {
            String page = LOGINPAGE.getText();
            Assert.assertEquals(page,"Login to dubdub.ai");
           // reportPass("with wrong credential it's not  showed any Error message");
        }
        else if(scenario.equals("CorrectEmail")) {
            String page = LOGINPAGE.getText();
            Assert.assertEquals(page,"Login to dubdub.ai");
           // reportPass("with Correct Email it's  showed any Error message for wrong password");
        }

        else if(scenario.equals("BothCorrectForSpeaker")){
            String page = title();
            Assert.assertEquals(page,"dubdub.ai");
        }
        else {
            String page = LOGINPAGE.getText();
            Assert.assertEquals(page,"Login to dubdub.ai");
            //reportPass("with Correct Password it's not  showed any Error message for Email");
            Thread.sleep(3000);
        }

        //val.closeBrowser();

    }


        //return new HomePage();

    }






