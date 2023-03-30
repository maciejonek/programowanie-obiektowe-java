package org.maciejonek.model;

public class InvoicePosition {
    public static final double TAX_05=0.05;
    public static final double TAX_08=0.08;
    public static final double TAX_23=0.23;
    private Product product;
    private int count;
    private double tax = TAX_23;

    public InvoicePosition(Product product) {
        this.product = product;
        this.count = 1;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    public double getNettoPrice(){
        return product.getPrice() * count;
    }
    public double getGrossPrice(){
        return getNettoPrice()*(1+tax);
    }
    public double getTaxValue(){
        return getGrossPrice()-getNettoPrice();
    }

}
