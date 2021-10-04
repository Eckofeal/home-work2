package bank;

import address.Address;
import bank.employee.Employee;
import bank.stock.*;
import сredit.*;
import сlient.*;
import bank.currency.*;

import java.time.LocalDateTime;

public class Bank {

    public static int count = 0;

    private Currency usd;
    private Currency eur;
    private Currency rub;
    private Currency byn;
    private String name;
    private Address adress;
    private LocalDateTime foundedAt;
    private Stock[] stockList;
    private Employee[] employees;
    private CreditType[] creditTypes;
    private Credit[] credits;

    public Bank(String name, Address adress, LocalDateTime foundedAt) {
        this.name = name;
        this.adress = adress;
        this.foundedAt = foundedAt;
        count++;
    }

    public Bank(String nameOfBank, Address adress, LocalDateTime whenFounded, Currency usd, Currency eur, Currency rub, Currency byn) {
        this(nameOfBank, adress, whenFounded);
        this.usd = usd;
        this.eur = eur;
        this.rub = rub;
        this.byn = byn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public Address getAdress() {
        return adress;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        this.foundedAt = foundedAt;
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

    public void setUsd(Currency usd) {
        this.usd = usd;
    }

    public Currency getUsd() {
        return usd;
    }

    public void setEur(Currency eur) {
        this.eur = eur;
    }

    public Currency getEur() {
        return eur;
    }

    public void setRub(Currency rub) {
        this.rub = rub;
    }

    public Currency getRub() {
        return rub;
    }

    public void setByn(Currency byn) {
        this.byn = byn;
    }

    public Currency getByn() {
        return byn;
    }

    public void setStockList(Stock[] stockList) {
        this.stockList = stockList;
    }

    public Stock[] getStockList() {
        return stockList;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setCredits(Credit[] credits) {
        this.credits = credits;
    }

    public Credit[] getCredits() {
        return credits;
    }

    public void setCreditTypes(CreditType[] creditTypes) {
        this.creditTypes = creditTypes;
    }

    public CreditType[] getCreditTypes() {
        return creditTypes;
    }

    public void addCreditType(CreditType creditType) {
        if (creditType == null) {
            return;
        }
        if (creditTypes != null) {
            if (indexOfCreditType(creditTypes, creditType) == -1) {
                creditTypes = add(creditTypes, creditType);
            } else {
                System.out.println("Credit type already exist.");
            }
        } else {
            creditTypes = add(creditTypes, creditType);
        }
    }

    public void removeCreditType(CreditType creditType) {
        if (creditType == null || creditTypes == null || creditTypes.length == 0) {
            return;
        }
        creditTypes = remove(creditTypes, creditType);
    }

    //OVERLOADED 1
    public CreditType[] findCreditType(String moneyType) {
        CreditType[] result;
        if (creditTypes != null && creditTypes.length > 0) {
            result = new CreditType[0];
            for (CreditType element : creditTypes) {
                if (element.getMoneyType() == moneyType) {
                    result = add(result, element);
                }
            }
        } else {
            return null;
        }
        return result;
    }

    //OVERLOADED 1
    public CreditType[] findCreditType(String moneyType, double moneyAmount) {
        CreditType[] result;
        if (creditTypes != null && creditTypes.length > 0) {
            result = new CreditType[0];
            for (CreditType element : creditTypes) {
                if (element.getMoneyType() == moneyType &&
                        (moneyAmount >= element.getMinMoneyAmount() &&
                                moneyAmount <= element.getMaxMoneyAmount())) {
                    result = add(result, element);
                }
            }
        } else {
            return null;
        }
        return result;
    }

    public void addCredit(Credit credit) {
        if (credits != null) {
            if (indexOfCredit(credits, credit) == -1) {
                credits = add(credits, credit);
            } else {
                System.out.println("Credit already exist.");
            }
        } else {
            credits = add(credits, credit);
        }
    }

    public void removeCredit(Credit credit) {
        if (credit == null || credits == null || credits.length == 0) {
            return;
        }
        credits = remove(credits, credit);
    }

    //OVERLOADED 2
    public Credit[] findCredit(Client client) {
        Credit[] result;
        if (client == null) {
            return null;
        }
        if (credits != null && credits.length > 0) {
            result = new Credit[0];
            for (Credit element : credits) {
                if (element.getClient().getFirstName() == client.getFirstName() &&
                        element.getClient().getLastName() == client.getLastName()) {
                    result = add(result, element);
                }
            }
        } else {
            return null;
        }
        return result;
    }

    //OVERLOADED 2
    public Credit[] findCredit(CreditType creditType) {
        Credit[] result;
        if (creditType == null) {
            return null;
        }
        if (credits != null && credits.length > 0) {
            result = new Credit[0];
            for (Credit element : credits) {
                if (element.getCreditType().getCreditName() == creditType.getCreditName()) {
                    result = add(result, element);
                }
            }
        } else {
            return null;
        }
        return result;
    }

    public void printBankInformation() {
        System.out.printf("%-60s%s%s", "\n", "BANK ININFORMATION:", "\n");
        System.out.println(name + ", located on " + adress.getCity() +
                ", " + adress.getStreet() + " " + adress.getHouseNumber() + " street, founded in " +
                foundedAt.getDayOfMonth() + "." + foundedAt.getMonth() + "." + foundedAt.getYear());
        System.out.println("Number of credit types in bank: " + creditTypes.length);
        System.out.println("Number of credits issued: " + credits.length);
        System.out.println("Bank capital:");
        System.out.println(usd.getAmount() + " " + Currency.USD);
        System.out.println(eur.getAmount() + " " + Currency.EURO);
        System.out.println(rub.getAmount() + " " + Currency.RUB);
        System.out.println(byn.getAmount() + " " + Currency.BYN);
    }

    private int indexOfCreditType(CreditType[] creditTypes, CreditType creditType) {
        int result = -1;
        if (creditTypes.length != 0) {
            int flag = 0;
            for (int i = 0; i < creditTypes.length; i++) {
                flag++;
                if (creditTypes[i].equals(creditType)) {
                    result = i;
                    return result;
                }
            }
            if (flag == creditTypes.length) {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

    private CreditType[] add(CreditType[] creditTypes, CreditType creditType) {
        if (creditType == null) {
            return creditTypes;
        }
        CreditType[] result;
        if (creditTypes == null) {
            result = new CreditType[1];
            result[0] = creditType;
        } else {
            result = new CreditType[creditTypes.length + 1];
            result = copyThenInsert(creditTypes, result, creditType);
        }
        return result;
    }

    private CreditType[] remove(CreditType[] creditTypes, CreditType creditType) {
        CreditType[] result = new CreditType[creditTypes.length - 1];
        int index = indexOfCreditType(creditTypes, creditType);
        for (int i = 0, j = 0; i < creditTypes.length; i++, j++) {
            if (i == index) {
                j--;
            } else {
                result[j] = creditTypes[i];
            }
        }
        return result;
    }

    private CreditType[] copyThenInsert(CreditType[] copyThis, CreditType[] intoThis, CreditType thenInsertThis) {
        for (int i = 0; i < intoThis.length; i++) {
            if (i != intoThis.length - 1) {
                intoThis[i] = copyThis[i];
            } else {
                intoThis[i] = thenInsertThis;
            }
        }
        return intoThis;
    }

    private int indexOfCredit(Credit[] credits, Credit credit) {
        int result = -1;
        if (credits.length != 0) {
            int flag = 0;
            for (int i = 0; i < credits.length; i++) {
                flag++;
                if (credits[i].equals(credit)) {
                    result = i;
                    return result;
                }
            }
            if (flag == credits.length) {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

    private Credit[] add(Credit[] credits, Credit credit) {
        if (credit == null) {
            return credits;
        }
        Credit[] result;
        if (credits == null) {
            result = new Credit[1];
            result[0] = credit;
        } else {
            result = new Credit[credits.length + 1];
            result = copyThenInsert(credits, result, credit);
        }
        return result;
    }

    private Credit[] remove(Credit[] credits, Credit credit) {
        Credit[] result = new Credit[credits.length - 1];
        int index = indexOfCredit(credits, credit);
        for (int i = 0, j = 0; i < credits.length; i++, j++) {
            if (i == index) {
                j--;
            } else {
                result[j] = credits[i];
            }
        }
        return result;
    }

    private Credit[] copyThenInsert(Credit[] copyThis, Credit[] intoThis, Credit thenInsertThis) {
        for (int i = 0; i < intoThis.length; i++) {
            if (i != intoThis.length - 1) {
                intoThis[i] = copyThis[i];
            } else {
                intoThis[i] = thenInsertThis;
            }
        }
        return intoThis;
    }
}