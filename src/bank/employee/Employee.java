package bank.employee;
import bank.currency.Currency;
import work.Work;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee {

    public static int сount;

    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthday;
    private Currency salary;
    private String position;

    public Employee(String firstName, String lastName, LocalDateTime birthDay, String position, Currency salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthDay;
        int age = (int) ChronoUnit.YEARS.between(this.birthday, LocalDateTime.now());
        if(age > 18 && age < 150) {
            this.age = age;
        }
        this.position = position;
        this.salary = salary;
        сount++;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return  firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        if(age > 18 && age < 150) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setBirthday(LocalDateTime birthday) {
            this.birthday = birthday;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setSalary(Currency salary) {
            this.salary = salary;
    }

    public Currency getSalary() {
        return salary;
    }

    public void setPosition(String position) {
            this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void printEmployee() {
        System.out.println("Employee: " + lastName + " " + firstName);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary.getAmount() + " " + salary.getType());
        System.out.println("Born: " + birthday.getDayOfMonth() + "." + birthday.getMonth() + "." + birthday.getYear());
        System.out.println("Age: " + age);
    }
}
