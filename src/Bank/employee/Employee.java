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
        if(!firstName.isEmpty()) {
            this.firstName = firstName;
        }
        if(!lastName.isEmpty()) {
            this.lastName = lastName;
        }
        if(birthDay != null) {
            this.birthday = birthDay;
        }
        int age = (int) ChronoUnit.YEARS.between(this.birthday, LocalDateTime.now());
        if(age > 0 && age < 150) {
            this.age = age;
        }
        if(!position.isEmpty()) {
            this.position = position;
        }
        if(salary != null) {
            this.salary = salary;
        }
        сount++;
    }

    public void setFirstName(String firstName) {
        if(!firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getFirstName() {
        return  firstName;
    }

    public void setLastName(String lastName) {
        if(!lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        if(age > 0 && age < 150) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setBirthday(LocalDateTime birthday) {
        if(birthday != null) {
            this.birthday = birthday;
        }
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setSalary(Currency salary) {
        if(salary != null) {
            this.salary = salary;
        }
    }

    public Currency getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        if(position.isEmpty()) {
            this.position = position;
        }
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
