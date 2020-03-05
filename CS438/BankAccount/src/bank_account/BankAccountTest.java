package bank_account;

public class BankAccountTest {

    public static void main(String[] args) throws InterruptedException {

        int initialBalance = 100000;
        BankAccount bankAccount = new BankAccountNTS(initialBalance);
        int numberOfHolders = 20;
        int amount = 100;
        int numberOfTransactions = 6;

        AccountHolder[] holders = new AccountHolder[numberOfHolders];
        for (int i = 0; i < numberOfHolders; i++) {
            holders[i] = new AccountHolder(bankAccount, i, amount, numberOfTransactions);
        }

        Thread[] threadHolders = new Thread[numberOfHolders];
        for (int i = 0; i < numberOfHolders; i++) {
            threadHolders[i] = new Thread(holders[i]);
            threadHolders[i].start();
        }
        for (int i = 0; i < numberOfHolders; i++) {
            threadHolders[i].join();
        }

        if (bankAccount.getBalance() == initialBalance) {
            System.out.format("Correct, the final balance is %s%n", bankAccount.getBalance());
        }
        else {
            System.out.format("Error, the initial balance is %s, the final is %s%n",
                    initialBalance, bankAccount.getBalance());
        }

    }

}
