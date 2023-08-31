package P5;

public class Problem5 {
    // This function is a demo for the classes created within problem 5 (Bank, Account, Customer)
    static public void main(String[] args) {
        Bank gizaBank = new Bank();

        // First customer transactions
        Customer khaled = new Customer("Khaled");

        createAccountForCustomer(gizaBank, khaled);

        khaled.getAccounts().get(0).depositMoney(5000);
        khaled.getAccounts().get(0).depositMoney(8000);

        createAccountForCustomer(gizaBank, khaled);

        khaled.getAccounts().get(1).withdrawMoney(9000);
        khaled.getAccounts().get(0).withdrawMoney(7000);

        removeAccountForCustomer(gizaBank, khaled, 1);


        // Second customer transactions
        Customer honda = new Customer("Honda");

        createAccountForCustomer(gizaBank, honda);
        honda.getAccounts().get(0).depositMoney(6000);
        honda.getAccounts().get(0).depositMoney(10000);

        honda.getAccounts().get(0).withdrawMoney(12000);

        System.out.println(gizaBank.accounts);
    }

    static public void createAccountForCustomer(Bank bank, Customer customer) {
        Account account = bank.createNewAccount(customer.getName());
        customer.addAccount(account);
    }

    static public void removeAccountForCustomer(Bank bank, Customer customer, int accountIndex) {
        Account account = customer.getAccounts().get(accountIndex);
        int money = bank.removeAccount(account);
        customer.takeMoney(money);

        customer.removeAccount(account);
    }
}
