package pages.PageComponents;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponents {

    SelenideElement VOICEOVER= $(Selectors.byXpath("//a[normalize-space()='Voiceover']"));

    public void selectVoiceoverFromLeftMenuBar(){
        VOICEOVER.shouldBe(visible).click();
    }

}
