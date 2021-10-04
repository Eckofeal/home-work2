package сlient;
import work.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Client {

    public static int сount;

    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthday;
    private Work work;

    public Client(String firstName, String lastName, LocalDateTime birthDay, Work work) {
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
        if(work != null) {
            this.work = work;
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

    public void setWork(Work work) {
        if(work != null) {
            this.work = work;
        }
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
