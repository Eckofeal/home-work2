package Client;
import Work.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Client {
    public static int clientCount;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthDay;
    private Work work;

    public Client(String firstName, String lastName, LocalDateTime birthDay, Work work) {
        if(!firstName.isEmpty()) this.firstName = firstName;
        if(!lastName.isEmpty()) this.lastName = lastName;
        if(birthDay != null) this.birthDay = birthDay;
        int age = (int) ChronoUnit.YEARS.between(this.birthDay, LocalDateTime.now());
        if(age > 0 && age < 150) this.age = age;
        if(work != null) this.work = work;
        clientCount++;
    }

    public void setFirstName(String firstName) {
        if(!firstName.isEmpty()) this.firstName = firstName;
    }

    public String getFirstName() {
        return  firstName;
    }

    public void setLastName(String lastName) {
        if(!lastName.isEmpty()) this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        if(age > 0 && age < 150) this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        if(birthDay != null) this.birthDay = birthDay;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setWork(Work work) {
        if(work != null) this.work = work;
    }

    public Work getWork() {
        return work;
    }

    public void printClient() {
        System.out.println("Client: " + lastName + " " + firstName);
        System.out.println("Born: " + birthDay.getDayOfMonth() + "." + birthDay.getMonth() + "." + birthDay.getYear());
        System.out.println("Age: " + age);
        work.printWork();
    }
}
