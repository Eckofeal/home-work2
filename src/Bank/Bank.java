package Bank;
import Bank.currencies.*;
import Credit.*;
import Client.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
//qweq
public class Bank {
    public static int bankCount;
    private Usd usd;
    private Euro eur;
    private Rub rub;
    private Byn byn;
    private String nameOfBank;
    private LocalDateTime whenFounded;
    private ArrayList<CreditType> creditTypeList;
    private ArrayList<Credit> creditList;

    public Bank(String nameOfBank, LocalDateTime whenFounded) {
        if (!nameOfBank.isEmpty()) this.nameOfBank = nameOfBank;
        if(whenFounded != null) this.whenFounded = whenFounded;
        bankCount++;
    }

    public Bank(String nameOfBank,LocalDateTime whenFounded, Usd usd, Euro eur, Rub rub, Byn byn) {
        this(nameOfBank, whenFounded);
        if (usd != null) this.usd = usd;
        if (eur != null) this.eur = eur;
        if (rub != null) this.rub = rub;
        if (byn != null) this.byn = byn;
    }

    public void setNameOfBank(String nameOfBank) {
        if (!nameOfBank.isEmpty()) this.nameOfBank = nameOfBank;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setWhenFounded(LocalDateTime whenFounded) {
        if(whenFounded != null) this.whenFounded = whenFounded;
    }

    public LocalDateTime getWhenFounded() {
        return whenFounded;
    }

    public void setUsd(Usd usd) {
        if (usd != null) this.usd = usd;
    }

    public Usd getUsd() {
        return usd;
    }

    public void setEur(Euro eur) {
        if (eur != null) this.eur = eur;
    }

    public Euro getEur() {
        return eur;
    }

    public void setRub(Rub rub) {
        if (rub != null) this.rub = rub;
    }

    public Rub getRub() {
        return rub;
    }

    public void setByn(Byn byn) {
        if (byn != null) this.byn = byn;
    }

    public Byn getByn() {
        return byn;
    }

    public void setCreditList(ArrayList<Credit> creditList) {
        if (creditList != null) this.creditList = creditList;
    }

    public ArrayList<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditTypeList(ArrayList<CreditType> creditTypeList) {
        if (creditTypeList != null) this.creditTypeList = creditTypeList;
    }

    public ArrayList<CreditType> getCreditTypeList() {
        return creditTypeList;
    }

    public void addCreditType(CreditType creditType) {
        if (creditType == null) return;
        if (creditTypeList != null) {
            if (creditTypeList.indexOf(creditType) == -1) {
                creditTypeList.add(creditType);
            } else {
                System.out.println("Credit.Credit type already exist.");
                return;
            }
        } else {
            creditTypeList = new ArrayList<CreditType>();
            creditTypeList.add(creditType);
        }
    }

    //OVERLOADED 1
    public void removeCreditType(CreditType creditType) {
        if (creditType == null) return;
        if (creditTypeList == null || creditTypeList.size() == 0) return;
        else {
            int index = creditTypeList.indexOf(creditType);
            if (index == -1) return;
            else creditTypeList.remove(index);
        }
    }

    //OVERLOAD 1
    public void removeCreditType(int index) {
        if (creditTypeList == null || creditTypeList.size() == 0) return;
        else creditTypeList.remove(index);
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(String moneyType) {
        ArrayList<CreditType> returnList;
        if (moneyType.isEmpty()) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == moneyType) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(String moneyType, double moneyAmount) {
        ArrayList<CreditType> returnList;
        if (moneyAmount <= 0) return null;
        else if(moneyType.isEmpty()) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == moneyType &&
                            (moneyAmount >= element.getMinMoneyAmount() &&
                                    moneyAmount <= element.getMaxMoneyAmount())) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(Euro eur) {
        ArrayList<CreditType> returnList;
        if (eur == null) return null;
        if (eur.getMoneyAmount() <= 0) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == Euro.MONEYTYPE &&
                            (eur.getMoneyAmount() >= element.getMinMoneyAmount() &&
                                    eur.getMoneyAmount() <= element.getMaxMoneyAmount())) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(Usd usd) {
        ArrayList<CreditType> returnList;
        if (usd == null) return null;
        if (usd.getMoneyAmount() <= 0) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == Usd.MONEYTYPE &&
                            (usd.getMoneyAmount() >= element.getMinMoneyAmount() &&
                                    usd.getMoneyAmount() <= element.getMaxMoneyAmount())) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(Rub rub) {
        ArrayList<CreditType> returnList;
        if (rub == null) return null;
        if (rub.getMoneyAmount() <= 0) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == Rub.MONEYTYPE &&
                            (rub.getMoneyAmount() >= element.getMinMoneyAmount() &&
                                    rub.getMoneyAmount() <= element.getMaxMoneyAmount())) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    //OVERLOADED 2
    public ArrayList<CreditType> findCreditType(Byn byn) {
        ArrayList<CreditType> returnList;
        if (byn == null) return null;
        if (byn.getMoneyAmount() <= 0) return null;
        else {
            if (creditTypeList != null && creditTypeList.size() > 0) {
                returnList = new ArrayList<CreditType>();
                for (CreditType element : creditTypeList) {
                    if (element.getMoneyType() == Rub.MONEYTYPE &&
                            (byn.getMoneyAmount() >= element.getMinMoneyAmount() &&
                                    byn.getMoneyAmount() <= element.getMaxMoneyAmount())) returnList.add(element);
                }
            } else {
                return null;
            }
        }
        return returnList;
    }

    public void addCredit(Credit credit) {
        if (credit == null) return;
        if (creditList != null) {
            if (creditList.indexOf(credit) == -1) {
                creditList.add(credit);
            } else {
                System.out.println("Credit.Credit already exist.");
                return;
            }
        } else {
            creditList = new ArrayList<Credit>();
            creditList.add(credit);
        }
    }

    //OVERLOADED 3
    public void removeCredit(Credit credit) {
        if (credit == null) return;
        if (creditList == null || creditList.size() == 0) return;
        else {
            int index = creditList.indexOf(credit);
            if (index == -1) return;
            else creditList.remove(index);
        }
    }

    //OVERLOADED 3
    public void removeCredit(int index) {
        if (creditList == null || creditList.size() == 0) return;
        else creditList.remove(index);
    }

    //OVERLOADED 4
    public ArrayList<Credit> findCredit(Client client) {
        ArrayList<Credit> returnList;
        if (client == null) return null;
        if (creditList != null && creditList.size() > 0) {
            returnList = new ArrayList<Credit>();
            for (Credit element : creditList) {
                if (element.getClient().getFirstName() == client.getFirstName() &&
                        element.getClient().getLastName() == client.getLastName()) {
                    returnList.add(element);
                }
            }
        } else {
            return null;
        }
        return returnList;
    }
    //OVERLOADED 4
    public ArrayList<Credit> findCredit(CreditType creditType) {
        ArrayList<Credit> returnList;
        if (creditType == null) return null;
        if (creditList != null && creditList.size() > 0) {
            returnList = new ArrayList<Credit>();
            for (Credit element : creditList) {
                if (element.getCreditType().getCreditName() == creditType.getCreditName()) {
                    returnList.add(element);
                }
            }
        } else {
            return null;
        }
        return returnList;
    }

    public void printBankInformation() {
        System.out.printf("%-60s%s%s", "\n", "BANK ININFORMATION:", "\n");
        System.out.println(nameOfBank + " founded in " + whenFounded.getDayOfMonth() + "." +
                whenFounded.getMonth() + "." + whenFounded.getYear());
        System.out.println("Number of credit types in bank :" + creditTypeList.size());
        System.out.println("Number of credits issued :" + creditList.size());
        System.out.println("Bank capital:");
        System.out.println(usd.getMoneyAmount() + " " + Usd.MONEYTYPE);
        System.out.println(eur.getMoneyAmount() + " " + Euro.MONEYTYPE);
        System.out.println(rub.getMoneyAmount() + " " + Rub.MONEYTYPE);
        System.out.println(byn.getMoneyAmount() + " " + Byn.MONEYTYPE);
    }
}