package bank_account;

import java.util.Random;

public class AccountHolder implements Runnable {

    private final static int MIN_WAIT = 1;
    private final static int MAX_WAIT = 3;

    private Random random = new Random();
    private int id;
    private BankAccount bankAccount;
    private int balance;
    private int numberOfTransactions;

    public AccountHolder(BankAccount bankAccount, int id, int balance, int numberOfTransactions) {
        this.id = id;
        if (numberOfTransactions % 2 != 0) {
            throw new RuntimeException("Number of transactions must be even.");
        }
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.numberOfTransactions = numberOfTransactions;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numberOfTransactions; i++) {
                randomWait();
                if (i % 2 == 0) {
                    bankAccount.deposit(balance);
                }
                else {
                    bankAccount.withdraw(balance);
                }
            }
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    private void randomWait() throws InterruptedException {
        Thread.sleep((random.nextInt(MAX_WAIT - MIN_WAIT + 1) + MIN_WAIT));
    }

}
