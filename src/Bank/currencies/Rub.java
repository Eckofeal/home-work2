package Bank.currencies;

public class Rub {
    public static final String MONEYTYPE = "RUB";
    private double moneyAmount;

    public Rub(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Rub() {
        this(0);
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void printMoneyAmount() {
        System.out.println(moneyAmount + " " + MONEYTYPE);
    }
}
