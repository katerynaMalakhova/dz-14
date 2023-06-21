package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OverviewPage extends AbstractPageObject{
    private final By buttonsMenuOption = By.xpath("//span[contains(text(), \"Buttons\")]");

    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }
    public ButtonsPage clickOnButtons(){
        getElement(buttonsMenuOption).click();
        return new ButtonsPage(driver);
}

}
