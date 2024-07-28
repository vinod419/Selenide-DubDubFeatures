package pages;

import pages.PageComponents.LeftMenuComponents;

public class HomePage {
    private final LeftMenuComponents leftMenuComponents;

    public HomePage(){
        this.leftMenuComponents = new LeftMenuComponents();
    }

    public LeftMenuComponents getLeftMenuComponents() {
        return leftMenuComponents;
    }
}
