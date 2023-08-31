package P5;

import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts;

    Bank() {
        System.out.println("Bank Created");
        accounts = new ArrayList<>();
    }

    public Account createNewAccount(String customerName) {
        Account newAccount = new Account(customerName);
        accounts.add(newAccount);

        return newAccount;
    }

    public int removeAccount(Account account) {
        if (accounts.contains(account)) {
            System.out.println("Account with id " + account.getAccountId() + " removed successfully");
            accounts.remove(account);
            return account.getBalance();
        }
        System.out.println("Failed to remove account with id " + account.getAccountId());
        return 0;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + accounts +
                '}';
    }
}
