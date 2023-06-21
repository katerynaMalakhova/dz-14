package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebtablesPage extends AbstractPageObject {
    private final By addButton = By.xpath("//button[@id=\"addNewRecordButton\"]");
    private final By firstNameInput = By.xpath("//input[@id=\"firstName\"]");
    private final By lastNameInput = By.xpath("//input[@id=\"lastName\"]");
    private final By userEmailInput = By.xpath("//input[@id=\"userEmail\"]");
    private final By ageInput = By.xpath("//input[@id=\"age\"]");
    private final By salaryInput = By.xpath("//input[@id=\"salary\"]");
    private final By departmentInput = By.xpath("//input[@id=\"department\"]");
    private final By submitButton = By.xpath("//button[@id=\"submit\"]");
    private final By employeeTableRows = By.xpath(".//div[@class='rt-tr-group']");
    private final By employeeTableCells = By.xpath(".//div[@class='rt-td']");
    private final By editButton = By.xpath("//div[@class='action-buttons']//span[contains(@id, 'edit')]");

    private final By deleteButton = By.xpath("//div[@class='action-buttons']//span[contains(@id, 'delete')]");


    public WebtablesPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }


    public boolean addNewEmployee(Employees employee) {
        return addNewEmployeeInfo(employee)
                .isExist(employee);
    }

    public boolean updateEmployee(Employees employeeChangeFrom, Employees employeeChangeTo) {
        int index = getIndex(employeeChangeFrom);
        getElements(editButton).get(index).click();
        return editEmployeeInfo(employeeChangeTo)
                .isExist(employeeChangeTo);
    }

    public boolean deleteEmployee(Employees employee) {
        int index = getIndex(employee);
        getElements(deleteButton).get(index).click();
        return isExist(employee);
    }

        public WebtablesPage addNewEmployeeInfo(Employees employee) {
            getElement(addButton).click();
            getElement(firstNameInput).sendKeys(employee.getFirstName());
        getElement(lastNameInput).sendKeys(employee.getLastname());
        getElement(userEmailInput).sendKeys(employee.getUserEmail());
        getElement(ageInput).sendKeys(employee.getAge());
        getElement(salaryInput).sendKeys(employee.getSalary());
        getElement(departmentInput).sendKeys(employee.getDepartment());
        getElement(submitButton).click();
        return this;
    }

    public WebtablesPage editEmployeeInfo( Employees employeeChangeTo) {
        getElement(firstNameInput).clear();
        getElement(firstNameInput).sendKeys(employeeChangeTo.getFirstName());
        getElement(lastNameInput).clear();
        getElement(lastNameInput).sendKeys(employeeChangeTo.getLastname());
        getElement(userEmailInput).clear();
        getElement(userEmailInput).sendKeys(employeeChangeTo.getUserEmail());
        getElement(ageInput).clear();
        getElement(ageInput).sendKeys(employeeChangeTo.getAge());
        getElement(salaryInput).clear();
        getElement(salaryInput).sendKeys(employeeChangeTo.getSalary());
        getElement(departmentInput).clear();
        getElement(departmentInput).sendKeys(employeeChangeTo.getDepartment());
        getElement(submitButton).click();
        return this;
    }


    public boolean isExist(Employees employee) {
        List<Employees> employees = getEmployees();
        return employees.contains(employee);
    }

    public int getIndex(Employees employee) {
        int index;
        List<Employees> employees = getEmployees();
        index = employees.indexOf(employee);
        return index;
    }

    public List<Employees> getEmployees() {
        List<Employees> employees = new ArrayList<>();
        List<WebElement> rowList = getElements(employeeTableRows, 5);

        for (WebElement row: rowList){
            List<WebElement> cellList = row.findElements(employeeTableCells);
            if(!cellList.get(0).getText().isEmpty()){
                Employees employee = new Employees();
                employee.setFirstName(cellList.get(0).getText());
                employee.setLastname(cellList.get(1).getText());
                employee.setAge(cellList.get(2).getText());
                employee.setUserEmail(cellList.get(3).getText());
                employee.setSalary(cellList.get(4).getText());
                employee.setDepartment(cellList.get(5).getText());

                employees.add(employee);
                }
            }
        return employees;
    }
}