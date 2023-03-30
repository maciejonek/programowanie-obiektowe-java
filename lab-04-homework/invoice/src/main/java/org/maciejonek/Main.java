package org.maciejonek;

import org.maciejonek.model.Invoice;
import org.maciejonek.model.InvoiceChecker;
import org.maciejonek.model.InvoicePosition;
import org.maciejonek.model.Product;


import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        InvoiceChecker checker = new InvoiceChecker();
        Product product = new Product("ABC123","TV",1000);
        System.out.println("Code: "+product.getCode());
        System.out.println("Name: "+product.getName());
        System.out.println("Price: "+product.getPrice());

        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_05);
        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_08);
        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_23);

        InvoicePosition position = new InvoicePosition(product);
        System.out.println(position.getNettoPrice());
        System.out.println(position.getGrossPrice());

        Invoice invoice = new Invoice(LocalDate.of(2023,04,02));
        invoice.addPosition(position);
        printoutInvoice(invoice);

        Invoice invoice1 = new Invoice(LocalDate.of(2023,03,02));
        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("CBA321","Radio",500));
        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("CBA321","Radio",500));
        invoice.setFullAmount();
        invoice1.setFullAmount();
        printoutInvoice(invoice1);
        checker.addInvoice(invoice);
        checker.addInvoice(invoice1);
        checker.performDateCheck();;

    }

    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOŚC\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK");
        System.out.println("*********************************************************************");
        for(InvoicePosition p : invoice.getPositions()){
            System.out.print('|'+p.getProduct().getName()+"\t\t|");
            System.out.print(p.getCount()+"\t\t|");
            System.out.print(p.getNettoPrice()+"\t\t|");
            System.out.print(p.getGrossPrice()+"\t\t|");
            System.out.print(p.getTax()+"\t\t|");
            System.out.println(p.getTaxValue());
            System.out.println("*********************************************************************");
        }
    }

}