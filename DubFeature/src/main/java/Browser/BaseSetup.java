package Browser;

import Listeners.TestListener;
import com.aventstack.extentreports.ExtentTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

@Listeners({TestListener.class})
public class BaseSetup {

    public ThreadLocal<WebDriverRunner> driver = new ThreadLocal<>();
    public static Logger log21 = Logger.getLogger("");


    @BeforeClass
    @Parameters({"url"})
        public void setupTest(@Optional("https://app.dubdub.ai") String url){
        ExtentTest classLevelTest = TestListener.extent.createTest(getClass().getSimpleName());
        TestListener.classLevelLog.set(classLevelTest);
        if (browser == "chrome") {
           Configuration.screenshots = true;
           Configuration.browserSize =  "2100x1080";
           open(url);
        }
       if (browser=="firefox") {
           Configuration.screenshots = true;
           Configuration.browserSize =  "2100x1080";
           open(url);
        }
        log21.info("initiated " + getClass());
    }

    @AfterClass
    public void teardown() {
       WebDriverRunner.getWebDriver().close();
    }

   public synchronized WebDriver getDriver() {
      return WebDriverRunner.getWebDriver();
   }

    @BeforeMethod(alwaysRun = true)
    public void clickOnRegisterButton(ITestResult result){
        ExtentTest extentTest = TestListener.classLevelLog.get().createNode(result.getMethod().getMethodName(),result.getMethod().getDescription());
        TestListener.test.set(extentTest);
        TestListener.test.get().info("Started execution");

    }
}


