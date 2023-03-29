package com.pjatk.bank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankAccountOperation {
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;
    private double money = 0;
    private BankOperationType type;
    private LocalDateTime time;

    public BankAccountOperation(BankOperationType type) {
        this.type = type;
    }

    public void setSourceBankAccount(BankAccount account) {
        this.sourceBankAccount = account;
    }

    public BankAccount getSourceBankAccount() {
        return sourceBankAccount;
    }
    public void setTargetBankAccount(BankAccount targetBankAccount) {
        this.targetBankAccount = targetBankAccount;
    }

    public BankAccount getTargetBankAccount() {
        return targetBankAccount;
    }

    public void setDate(LocalDateTime date) {
        this.time = date;
    }

    public LocalDateTime getDate() {
        return time;
    }

    public BankOperationType getType() {
        return type;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }


}
