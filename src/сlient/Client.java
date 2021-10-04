package сlient;

import work.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Client {

    public static int сount = 0;

    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthday;
    private Work work;

    public Client(String firstName, String lastName, LocalDateTime birthDay, Work work) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthDay;
        int age = (int) ChronoUnit.YEARS.between(this.birthday, LocalDateTime.now());
        if (age > 18 && age < 150) {
            this.age = age;
        }
        this.work = work;
        сount++;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        if (age > 18 && age < 150) {
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

    public void setWork(Work work) {
        this.work = work;
    }

    public Work getWork() {
        return work;
    }

    public void printClient() {
        System.out.println("Client: " + lastName + " " + firstName);
        System.out.println("Born: " + birthday.getDayOfMonth() + "." + birthday.getMonth() + "." + birthday.getYear());
        System.out.println("Age: " + age);
        work.printWork();
    }
}
