package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends AbstractPageObject{
    private final By clickMeButton = By.xpath("//button[text()=\"Click Me\"]");
    private final By dynamicMessage = By.xpath("//p[@id=\"dynamicClickMessage\"]");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage clickOnClickMe(){
        getElement(clickMeButton, 4).click();
        return this;
    }
    public String getMessage(){
        return getElement(dynamicMessage).getText();
    }

}
