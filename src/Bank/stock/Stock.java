package bank.stock;
import bank.currency.Currency;

public class Stock {

    private String companyName;
    private long stockNumber;
    private Currency costPerStock;

    public Stock(String companyName, long stockNumber, Currency costPerShare) {
        if(!companyName.isEmpty()) {
            this.companyName = companyName;
        }
        if(stockNumber >= 0) {
            this.stockNumber = stockNumber;
        }
        if(costPerShare != null) {
            this.costPerStock = costPerShare;
        }
    }

    public void setCompanyName(String companyName) {
        if(!companyName.isEmpty()) {
            this.companyName = companyName;
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setSharesNumber(long stockNumber) {
        if(stockNumber >= 0) {
            this.stockNumber = stockNumber;
        }
    }

    public long getSharesNumber() {
        return stockNumber;
    }

    public void setCostPerStock(Currency costPerStock) {
        if(costPerStock != null) {
            this.costPerStock = costPerStock;
        }
    }

    public Currency getCostPerStock() {
        return costPerStock;
    }

    public void printStock() {
        System.out.println("Shares of the company \"" + companyName + "\":");
        System.out.println("Cost per share: " + costPerStock.getAmount() + " " + costPerStock.getType());
    }
}
