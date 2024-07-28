package testsuites;

import Browser.BaseSetup;
import org.testng.annotations.Test;
import pages.Casting;
import pages.Login;

public class TestOnDubEditorFlow extends BaseSetup {
    @Test(priority = 1)
    public void myvideoPage() throws InterruptedException {
        new Login().loginForAll();
        new Casting().EnterTheProject();
    }
    @Test(priority = 2)
    public void CastingPage() throws InterruptedException {
        new Casting().addSpeaker();
        new Casting().changeSpeaker();

    }
}
