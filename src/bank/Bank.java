package bank;
import adress.Adress;
import bank.employee.Employee;
import bank.stock.*;
import сredit.*;
import сlient.*;
import bank.currency.*;
import java.time.LocalDateTime;

public class Bank {

    public static int count;

    private Currency usd;
    private Currency eur;
    private Currency rub;
    private Currency byn;
    private String name;
    private Adress adress;
    private LocalDateTime foundedAt;
    private Stock[] stockList;
    private Employee[] employees;
    private CreditType[] creditTypeList;
    private Credit[] creditList;

    public Bank(String name, Adress adress, LocalDateTime foundedAt) {
        if (!name.isEmpty()) {
            this.name = name;
        }
        if(adress != null) {
            this.adress = adress;
        }
        if(foundedAt != null) {
            this.foundedAt = foundedAt;
        }
        count++;
    }

    public Bank(String nameOfBank, Adress adress, LocalDateTime whenFounded, Currency usd, Currency eur, Currency rub, Currency byn) {
        this(nameOfBank, adress, whenFounded);
        if (usd != null) {
            this.usd = usd;
        }
        if (eur != null) {
            this.eur = eur;
        }
        if (rub != null) {
            this.rub = rub;
        }
        if (byn != null) {
            this.byn = byn;
        }
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setAdress(Adress adress) {
        if(adress != null) {
            this.adress = adress;
        }
    }

    public Adress getAdress() {
        return adress;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        if(foundedAt != null) {
            this.foundedAt = foundedAt;
        }
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

    public void setUsd(Currency usd) {
        if (usd != null) {
            this.usd = usd;
        }
    }

    public Currency getUsd() {
        return usd;
    }

    public void setEur(Currency eur) {
        if (eur != null) {
            this.eur = eur;
        }
    }

    public Currency getEur() {
        return eur;
    }

    public void setRub(Currency rub) {
        if (rub != null) {
            this.rub = rub;
        }
    }

    public Currency getRub() {
        return rub;
    }

    public void setByn(Currency byn) {
        if (byn != null) {
            this.byn = byn;
        }
    }

    public Currency getByn() {
        return byn;
    }

    public void setStockList(Stock[] stockList) {
        if(employees != null) {
            this.stockList = stockList;
        }
    }

    public Stock[] getStockList() {
        return stockList;
    }

    public void setEmployees(Employee[] employees) {
        if(employees != null) {
            this.employees = employees;
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setCreditList(Credit[] creditList) {
        if (creditList != null) {
            this.creditList = creditList;
        }
    }

    public Credit[] getCreditList() {
        return creditList;
    }

    public void setCreditTypeList(CreditType[] creditTypeList) {
        if (creditTypeList != null) {
            this.creditTypeList = creditTypeList;
        }
    }

    public CreditType[] getCreditTypeList() {
        return creditTypeList;
    }

    public void addCreditType(CreditType creditType) {
        if (creditType == null) {
            return;
        }
        if (creditTypeList != null) {
            if (indexOfCreditType(creditTypeList, creditType) == -1) {
                creditTypeList = add(creditTypeList, creditType);
            } else {
                System.out.println("Credit.Credit type already exist.");
                return;
            }
        } else {
            creditTypeList = add(creditTypeList, creditType);
        }
    }

    public void removeCreditType(CreditType creditType) {
        if (creditType == null) {
            return;
        }
        if (creditTypeList == null || creditTypeList.length == 0) {
            return;
        }
        else {
           creditTypeList = remove(creditTypeList, creditType);
        }
    }
    //OVERLOADED 1
    public CreditType[] findCreditType(String moneyType) {
        CreditType[] returnList;
        if (moneyType.isEmpty()) {
            return null;
        }
        else {
            if (creditTypeList != null && creditTypeList.length > 0) {
                returnList = new CreditType[0];
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == moneyType) {
                        returnList = add(returnList, element);
                    }
                }
            } else {
                return null;
            }
        }
        return returnList;
    }
    //OVERLOADED 1
    public CreditType[] findCreditType(String moneyType, double moneyAmount) {
        CreditType[] returnList;
        if (moneyAmount <= 0) {
            return null;
        }
        else if(moneyType.isEmpty()) {
            return null;
        }
        else {
            if (creditTypeList != null && creditTypeList.length > 0) {
                returnList = new CreditType[0];
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == moneyType &&
                            (moneyAmount >= element.getMinMoneyAmount() &&
                                    moneyAmount <= element.getMaxMoneyAmount())) {
                        returnList = add(returnList, element);
                    }
                }
            }
            else {
                return null;
            }
        }
        return returnList;
    }

    public void addCredit(Credit credit) {
        if (credit == null) {
            return;
        }
        if (creditList != null) {
            if (indexOfCredit(creditList, credit) == -1) {
                creditList = add(creditList, credit);
            } else {
                System.out.println("Credit already exist.");
                return;
            }
        } else {
            creditList = add(creditList, credit);
        }
    }

    public void removeCredit(Credit credit) {
        if (credit == null) {
            return;
        }
        if (creditList == null || creditList.length == 0) {
            return;
        }
        else {
            creditList = remove(creditList, credit);
        }
    }
    //OVERLOADED 2
    public Credit[] findCredit(Client client) {
        Credit[] returnList;
        if (client == null) {
            return null;
        }
        if (creditList != null && creditList.length > 0) {
            returnList = new Credit[0];
            for (Credit element : creditList) {
                if (element.getClient().getFirstName() == client.getFirstName() &&
                        element.getClient().getLastName() == client.getLastName()) {
                    returnList = add(returnList, element);
                }
            }
        } else {
            return null;
        }
        return returnList;
    }
    //OVERLOADED 2
    public Credit[] findCredit(CreditType creditType) {
        Credit[] returnList;
        if (creditType == null) {
            return null;
        }
        if (creditList != null && creditList.length > 0) {
            returnList = new Credit[0];
            for (Credit element : creditList) {
                if (element.getCreditType().getCreditName() == creditType.getCreditName()) {
                    returnList = add(returnList, element);
                }
            }
        } else {
            return null;
        }
        return returnList;
    }

    public void printBankInformation() {
        System.out.printf("%-60s%s%s", "\n", "BANK ININFORMATION:", "\n");
        System.out.println(name + ", located on " + adress.getSity() +
                ", " + adress.getStreet() + " " + adress.getHouseNumber() + " street, founded in " +
                foundedAt.getDayOfMonth() + "." + foundedAt.getMonth() + "." + foundedAt.getYear());
        System.out.println("Number of credit types in bank: " + creditTypeList.length);
        System.out.println("Number of credits issued: " + creditList.length);
        System.out.println("Bank capital:");
        System.out.println(usd.getAmount() + " " + Currency.USD);
        System.out.println(eur.getAmount() + " " + Currency.EURO);
        System.out.println(rub.getAmount() + " " + Currency.RUB);
        System.out.println(byn.getAmount() + " " + Currency.BYN);
    }

    public int indexOfCreditType(CreditType[] creditTypeList, CreditType creditType) {
        int result = -1;
        if(creditTypeList == null) {
            result = -1;
        }
        if(creditTypeList.length != 0 ) {
            int flag = 0;
            for (int i = 0; i < creditTypeList.length; i++) {
                flag++;
                if(creditTypeList[i].equals(creditType)) {
                    result = i;
                    return result;
                }
            }
            if(flag == creditTypeList.length) {
                result = -1;
            }
        }
        else {
            result = -1;
        }
        return result;
    }

    public CreditType[] add(CreditType[] creditTypeList, CreditType creditType) {
        if(creditType == null) {
            return creditTypeList;
        }
        CreditType[] returnList;
        if(creditTypeList == null) {
            returnList = new CreditType[1];
            returnList[0] = creditType;
        }
        else {
            returnList = new CreditType[creditTypeList.length+1];
            for(int i = 0; i < returnList.length; i++) {
                if(i != returnList.length-1) {
                    returnList[i] = creditTypeList[i];
                }
                else {
                    returnList[i] = creditType;
                }
            }
        }
        return returnList;
    }

    public CreditType[] remove(CreditType[] creditTypeList, CreditType creditType) {
        if(creditType == null) {
            return creditTypeList;
        }
        CreditType[] returnList;
        if(creditTypeList == null) {
            return creditTypeList;
        }
        else if(creditTypeList.length == 0) {
            return creditTypeList;
        }
        else {
            returnList = new CreditType[creditTypeList.length-1];
            int index = indexOfCreditType(creditTypeList, creditType);
            for(int i = 0, j = 0; i < creditTypeList.length; i++, j++) {
                if(i == index) {
                    j--;
                }
                else {
                    returnList[j] = creditTypeList[i];
                }
            }
        }
        return returnList;
    }

    public int indexOfCredit(Credit[] creditList, Credit credit) {
        int result = -1;
        if(creditList == null) {
            result = -1;
        }
        if(creditList.length != 0 ) {
            int flag = 0;
            for (int i = 0; i < creditList.length; i++) {
                flag++;
                if(creditList[i].equals(credit)) {
                    result = i;
                    return result;
                }
            }
            if(flag == creditList.length) {
                result = -1;
            }
        }
        else {
            result = -1;
        }
        return result;
    }

    public Credit[] add(Credit[] creditList, Credit credit) {
        if(credit == null) {
            return creditList;
        }
        Credit[] returnList;
        if(creditList == null) {
            returnList = new Credit[1];
            returnList[0] = credit;
        }
        else {
            returnList = new Credit[creditList.length+1];
            for(int i = 0; i < returnList.length; i++) {
                if(i != returnList.length-1) {
                    returnList[i] = creditList[i];
                }
                else {
                    returnList[i] = credit;
                }
            }
        }
        return returnList;
    }

    public Credit[] remove(Credit[] creditList, Credit credit) {
        if(credit == null) {
            return creditList;
        }
        Credit[] returnList;
        if(creditList == null) {
            return creditList;
        }
        else if(creditList.length == 0) {
            return creditList;
        }
        else {
            returnList = new Credit[creditList.length-1];
            int index = indexOfCredit(creditList, credit);
            for(int i = 0, j = 0; i < creditList.length; i++, j++) {
                if(i == index) {
                    j--;
                }
                else {
                    returnList[j] = creditList[i];
                }
            }
        }
        return returnList;
    }
}