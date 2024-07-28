package testsuites;

import Browser.BaseSetup;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.AddCredits;
import pages.CreditTransacationFlow;
import pages.Login;
import java.awt.*;


public class TestOnCreditTransactionFlow extends BaseSetup {

        @Test(priority = 1)
        void Login() throws InterruptedException, AWTException {
                //new Login().loginForAll();
                new CreditTransacationFlow().signUp();
        }
        @Test(priority = 2)
        void TestOnHomePage() throws InterruptedException {
        new CreditTransacationFlow().homePage();
        }
        @Test(priority = 3)
        void TestOnCreateProject() {
                new CreditTransacationFlow().createProject();
        }
        @Test(priority = 4)
        void TestOnUploadFile() throws InterruptedException, AWTException {
                new CreditTransacationFlow().uploadFile();
        }
        @Test(priority = 5)
        void selectLanguage() throws InterruptedException {
                new CreditTransacationFlow().selectLanguage();
        }
        @Test(priority = 6)
        void testOnaddCredits() throws InterruptedException {
        new AddCredits().addCredits();
        }
}
