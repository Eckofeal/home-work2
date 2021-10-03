package Work;

public class Work {
    private String companyName;
    private String positionName;
    private int salary;
    private String moneyType;

    public Work(String companyName, String positionName, int salary, String moneyType) {
        if (!companyName.isEmpty()) this.companyName = companyName;
        if (!positionName.isEmpty()) this.positionName = positionName;
        if (salary > 0) this.salary = salary;
        if (moneyType == "BYN" || moneyType == "RUB" || moneyType == "EUR" || moneyType == "USD") this.moneyType = moneyType;
    }

    public void setCompanyName(String companyName) {
        if (!companyName.isEmpty()) this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPositionName(String positionName) {
        if (!positionName.isEmpty()) this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setSalary(int salary) {
        if (salary > 0) this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setMoneyType(String moneyType) {
        if (moneyType == "BYN" || moneyType == "RUB" || moneyType == "EUR" || moneyType == "USD") this.moneyType = moneyType;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void printWork(){
        System.out.println("Work: ");
        System.out.printf("%7s%-12s%s%n", "", "Company: ", companyName);
        System.out.printf("%7s%-12s%s%n", "", "Position: ", positionName);
        System.out.printf("%7s%-12s%s%4s%n", "", "Salary: ", salary, moneyType);
    }
}
