package com.pjatk.bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BankAccountManager {
    HashMap<String,BankAccount> accounts = new HashMap<>();
    HashMap<BankOperationType, ArrayList<BankAccountOperation>> operations = new HashMap<>();
    public void addAccount(BankAccount account) {
        if(!accounts.containsKey(account.getAccountNumber()))
            this.accounts.put(account.getAccountNumber(),account);
    }

    public void registerOperation(BankAccountOperation operation) {
        if(!operations.containsKey(operation.getType()))
            this.operations.put(operation.getType(),new ArrayList<>());
        this.operations.get(operation.getType()).add(operation);
    }

    public void performDeposits() {
        ArrayList<BankAccountOperation> depositList = operations.get(BankOperationType.DEPOSIT);
        for(BankAccountOperation deposit : depositList){
            for(BankAccount account : accounts.values()){
                if(account==deposit.getSourceBankAccount()){
                    account.setCurrentMoney(deposit.getMoney());
                }
            }
        }
    }

    public void performWithdrawals() {
        ArrayList<BankAccountOperation> withdrawalList = operations.get(BankOperationType.WITHDRAWAL);
            for(BankAccountOperation withdrawal : withdrawalList){
                for(BankAccount account : accounts.values()){
                    if(account.getCurrentMoney()>0 && account.getCurrentMoney()>=withdrawal.getMoney())
                        if(account==withdrawal.getSourceBankAccount()){
                            account.setCurrentMoney(account.getCurrentMoney()-withdrawal.getMoney());
                       }
                }
            }
    }

    public void performTransfers() {
        ArrayList<BankAccountOperation> transferList = operations.get(BankOperationType.TRANSFER);
        for (BankAccountOperation transfer : transferList) {
            for (BankAccount account : accounts.values())
                if (transfer.getDate().isBefore(LocalDateTime.now()))
                    if (account.getCurrentMoney() > 0 && account.getCurrentMoney() >= transfer.getMoney())
                        if (account == transfer.getSourceBankAccount())
                            account.setCurrentMoney(account.getCurrentMoney() - transfer.getMoney());
            for (BankAccount account : accounts.values())
                if (transfer.getDate().isBefore(LocalDateTime.now()))
                    if (account == transfer.getTargetBankAccount())
                        account.setCurrentMoney(account.getCurrentMoney() + transfer.getMoney());

        }
    }
}

