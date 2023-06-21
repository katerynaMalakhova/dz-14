package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OverviewPage;

public class ButtonClickTest extends BaseTest {
    @Test
    @Description("The test is checking dynamic message on click")
    public void testDynamicMesage() {
        String dynamicMessage = new OverviewPage(driver)
                .clickOnButtons()
                .clickOnClickMe()
                .getMessage();

        Assert.assertEquals(dynamicMessage, "You have done a dynamic click"
                , "The dynamic message is wrong");
    }
}
