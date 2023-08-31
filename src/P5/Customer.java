package P5;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Account> accounts;

    Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        if (accounts.contains(account))
            return;
        accounts.add(account);
    }

    public void takeMoney(int money) {
        System.out.println(name + " has taken " + money);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
