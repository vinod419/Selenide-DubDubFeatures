package testsuites;

import Browser.BaseSetup;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.DataProvider;
import pages.Login;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class TestOnLoginPage extends BaseSetup {


    void testOnlogin() throws IOException {
       /* ChromeOptions opt = new ChromeOptions();
        opt.addArguments("remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://app.stage.dubdub.ai");*/

        open("https://app.stage.dubdub.ai");

        Configuration.timeout = 30000;
        //Configuration.ma = true;
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = ChatCbDriver.class.getName();
    }

    @Test(priority = 2, dataProvider = "Validation")
    void testOnEmailAndPassword(String email, String password) {

        new Login()
                .email(email, password);

        new Login()
                .password(email, password);

    }

    @Test(priority = 3, dataProvider = "credentials")
    void testOnLogin(String scenario, String email, String password) throws InterruptedException {

        new Login()
                .login(scenario, email, password);

        // new VoiceOverPage().CreateVoiceOver();


        //new ScripPage()
        //        .EntertheText();


    }


    @DataProvider(name = "credentials")
    public Object[][] getData() {

        return new Object[][]{
                {"BothCorrect", "vinodkgowda007@gmail.com", "Vinod@123"},
                {"Bothwrong", "vinzz007gmailcom", "vinod123"},
                {"CorrectEmail", "vinodkgowda007@gmail.com", "vinod123"},
                {"Correctpassword", "vinzz007gmailcom", "Vinod@123"}
        };
    }

    @DataProvider(name = "Validation")
    public Object[][] getDatas() {

        return new Object[][]{

                {"vinodkgowda007@gmail.com", "vinod123"},
                {"vinzz007gmailcom", "Vinod@10.12.2000"}
        };

    }


}