package org.maciejonek.model;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.DAYS;

public class InvoiceChecker {
    private ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();

    public void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }
    public void performDateCheck(){
        for(Invoice i : invoiceList){
            if(i.getPaymentDate().isBefore(LocalDate.now())){
                i.addInterest(DAYS.between(i.getPaymentDate(),LocalDate.now()));
                System.out.println("To pay after interests: "+i.getFullAmount());
            }
            else System.out.println("To pay: "+i.getFullAmount());
        }
    }
}
