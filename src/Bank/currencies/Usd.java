package Bank.currencies;

public class Usd {
    public static final String MONEYTYPE = "USD";
    private double moneyAmount;

    public Usd(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Usd() {
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
