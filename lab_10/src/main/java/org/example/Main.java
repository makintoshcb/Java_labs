package org.example;

// Подсистема для работы с балансом счета
class AccountBalance {
    public double checkBalance(String accountNumber) {
        // Логика проверки баланса счета
        return 5000.0; // Возвращаем текущий баланс
    }
}

// Подсистема для выполнения пополнения счета
class AccountDeposit {
    public void deposit(String accountNumber, double amount) {
        // Логика пополнения счета
        System.out.println("Счет " + accountNumber + " успешно пополнен на сумму " + amount);
    }
}

// Подсистема для выполнения перевода средств
class AccountTransfer {
    public void transfer(String fromAccount, String toAccount, double amount) {
        // Логика перевода средств
        System.out.println("Со счета " + fromAccount + " переведено на счет " + toAccount + " сумма " + amount);
    }
}

// Фасад для банковской системы
class BankFacade {
    private AccountBalance balance;
    private AccountDeposit deposit;
    private AccountTransfer transfer;

    public BankFacade() {
        balance = new AccountBalance();
        deposit = new AccountDeposit();
        transfer = new AccountTransfer();
    }

    // Метод для проверки баланса счета
    public double checkBalance(String accountNumber) {
        return balance.checkBalance(accountNumber);
    }

    // Метод для пополнения счета
    public void deposit(String accountNumber, double amount) {
        deposit.deposit(accountNumber, amount);
    }

    // Метод для выполнения перевода
    public void transfer(String fromAccount, String toAccount, double amount) {
        transfer.transfer(fromAccount, toAccount, amount);
    }
}

// Пример использования паттерна Фасад
public class Main {
    public static void main(String[] args) {
        BankFacade bankFacade = new BankFacade();

        String accountNumber = "123456789";
        double initialBalance = bankFacade.checkBalance(accountNumber);
        System.out.println("Начальный баланс счета " + accountNumber + ": " + initialBalance);

        double depositAmount = 1000.0;
        bankFacade.deposit(accountNumber, depositAmount);
        double updatedBalance = bankFacade.checkBalance(accountNumber);
        System.out.println("Баланс счета после пополнения на сумму " + depositAmount + ": " + updatedBalance);

        String toAccount = "987654321";
        double transferAmount = 500.0;
        bankFacade.transfer(accountNumber, toAccount, transferAmount);
        double newBalance = bankFacade.checkBalance(accountNumber);
        System.out.println("Баланс счета после перевода суммы " + transferAmount + ": " + newBalance);
    }
}