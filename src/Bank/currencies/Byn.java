package Bank.currencies;

public class Byn {
    public static final String MONEYTYPE = "BYN";
    private double moneyAmount;

    public Byn(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Byn() {
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
