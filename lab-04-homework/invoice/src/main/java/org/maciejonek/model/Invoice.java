package org.maciejonek.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private static final double Interest = (0.08/365);
    private Buyer buyer;
    private LocalDate invoiceDate;
    private LocalDate paymentDate;
    private double fullAmount;
    private ArrayList<InvoicePosition> positions = new ArrayList<InvoicePosition>();

    public Invoice(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public ArrayList<InvoicePosition> getPositions() {
        return positions;
    }
    public void addPosition(InvoicePosition position){
        positions.add(position);
    }

    public void addInterest(long days) {
        this.fullAmount += Math.round(getFullAmount()*(days*Interest));
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount() {
        for (InvoicePosition p : positions){
            fullAmount+=p.getGrossPrice();
        }
    }

    private InvoicePosition positionWithProduct(Product product){
        for (InvoicePosition position : positions){
            if (position.getProduct().getCode().equals(product.getCode()))
                return position;
        }
        return null;
    }
    public void addPosition(Product product){
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }

}
