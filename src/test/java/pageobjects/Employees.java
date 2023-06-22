package pageobjects;

public class Employees {
    private String firstName;
    private String lastname;
    private String userEmail;
    private String age;
    private String salary;
    private String department;

    public Employees(String firstName, String lastname, String userEmail, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.userEmail = userEmail;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employees() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Employees) {
            Employees employee = (Employees) o;

            return this.firstName.equals(employee.firstName) &&
                    this.lastname.equals(employee.lastname) &&
                    this.age.equals(employee.age) &&
                    this.userEmail.equals(employee.userEmail) &&
                    this.salary.equals(employee.salary) &&
                    this.department.equals(employee.department);
        }
        return false;
    }


}
