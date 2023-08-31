package P5;

public class Account {
    static int currentId = 1;
    private final int accountId;
    private final String customerName;
    private int money;

    Account(String customerName) {
        // Open a new bank account with no money and with its own id
        money = 0;
        this.customerName = customerName;
        accountId = currentId++;
        System.out.println("Opened a new account for " + customerName + " with id " + accountId);
    }

    public int getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return money;
    }

    public void withdrawMoney(int money) {
        if (money > this.money) {
            System.out.println("Failed to withdraw " + money + " from account " + accountId + " due to insufficient funds! Current balance: " + this.money);
            return;
        }
        this.money -= money;
        System.out.println("Withdrawn " + money + " from account " + accountId + ", new balance: " + this.money);
    }

    public void depositMoney(int money) {
        this.money += money;
        System.out.println("Deposited " + money + " to account " + accountId + ", new balance: " + this.money);
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerName=" + customerName +
                ", accountId=" + accountId +
                ", money=" + money +
                '}';
    }
}
