package Credit;

public class CreditType {
    public static int creditTypeCount;
    private String creditName;
    private String moneyType;
    private int termInYears;
    private double yearPercent;
    private double minMoneyAmount;
    private double maxMoneyAmount;

    public CreditType(String creditName, String moneyType, int termInYears,
                      double yearPercent, double minMoneyAmount, double maxMoneyAmount) {
        if(!creditName.isEmpty()) this.creditName = creditName;
        if(!moneyType.isEmpty() &&
                (moneyType == "BYN" || moneyType == "RUB" ||
                        moneyType == "EUR" || moneyType == "USD")) {
            this.moneyType = moneyType;
        }
        this.yearPercent = yearPercent;
        if(termInYears > 0) this.termInYears = termInYears;
        if(minMoneyAmount > 0) this.minMoneyAmount = minMoneyAmount;
        if(maxMoneyAmount > 0) this.maxMoneyAmount = maxMoneyAmount;
        creditTypeCount++;
    }

    public void setCreditName(String creditName) {
        if(!creditName.isEmpty()) this.creditName = creditName;
    }

    public String getCreditName() {
        return  creditName;
    }

    public void setMoneyType(String moneyType) {
        if(!moneyType.isEmpty() &&
                (moneyType == "BYN" || moneyType == "RUB" ||
                        moneyType == "EUR" || moneyType == "USD")) {
            this.moneyType = moneyType;
        }
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setTermInYears(int termInYears) {
        if(termInYears > 0) this.termInYears = termInYears;
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
                + termInYears + " years at " + yearPercent +"% per year.");
    }
}
