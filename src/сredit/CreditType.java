package сredit;

public class CreditType {

    public static int count = 0;

    private String creditName;
    private String moneyType;
    private int termInYears;
    private double yearPercent;
    private double minMoneyAmount;
    private double maxMoneyAmount;

    public CreditType(String creditName, String moneyType, int termInYears,
                      double yearPercent, double minMoneyAmount, double maxMoneyAmount) {
        this.creditName = creditName;
        this.moneyType = moneyType;
        this.yearPercent = yearPercent;
        this.termInYears = termInYears;
        this.minMoneyAmount = minMoneyAmount;
        this.maxMoneyAmount = maxMoneyAmount;
        count++;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public void setYearPercent(double yearPercent) {
        this.yearPercent = yearPercent;
    }

    public double getYearPercent() {
        return yearPercent;
    }

    public void setMinMoneyAmount(double minMoneyAmount) {
        this.minMoneyAmount = minMoneyAmount;
    }

    public double getMinMoneyAmount() {
        return minMoneyAmount;
    }

    public void setMaxMoneyAmount(double maxMoneyAmount) {
        this.maxMoneyAmount = maxMoneyAmount;
    }

    public double getMaxMoneyAmount() {
        return maxMoneyAmount;
    }

    public void printCreditType() {
        System.out.println("Credit " + creditName + " from "
                + minMoneyAmount + " " + moneyType + " to "
                + maxMoneyAmount + " " + moneyType + " for a period of "
                + termInYears + " years at " + yearPercent + "% per year.");
    }
}
