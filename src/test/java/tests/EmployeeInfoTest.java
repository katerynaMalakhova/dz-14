package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Employees;
import pageobjects.WebtablesPage;

public class EmployeeInfoTest extends BaseTest {

    Employees employeeChangeFrom = new Employees("fn", "ln", "test@estt.com", "15", "1400", "test");
    Employees employeeChangeTo = new Employees("fn1", "ln1", "test1@estt.com", "16", "1500", "test1");


    @Test
    @Description("The test checks adding an employee")
    public void testAddEmployee() {
     boolean isAdded = new WebtablesPage(driver).addNewEmployee(employeeChangeFrom);
       Assert.assertTrue(isAdded, "Employee was not added");
     }

    @Test
    @Description("The test checks editing an employee")
    public void testEditEmployee(){
        WebtablesPage d = new WebtablesPage(driver);
            d.addNewEmployee(employeeChangeFrom);
            Assert.assertTrue(d.updateEmployee(employeeChangeFrom, employeeChangeTo),
                    "Employee was not updated");
        }

    @Test
    @Description("The test checks deteting an employee")
    public void testDeleteEmployee()  {
        WebtablesPage d = new WebtablesPage(driver);
        d.addNewEmployee(employeeChangeFrom);

        Assert.assertTrue(!d.deleteEmployee(employeeChangeFrom),
                "Employee was not deleted");
    }

}
