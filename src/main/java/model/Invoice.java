package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/** Represents an invoice
 */
public class Invoice implements Searchable {
    private UUID id;
    private Company issuer;
    private String placeOfIssue;
    private LocalDateTime created;
    private Company customer;
    private String cashier;
    private Items items;
    private BigDecimal total;
    private String typeOfPayment;
    private BigDecimal paid;
    private BigDecimal returned;
    private String invoiceNumber;
    private String zoi;
    private String eor;
    private String barcode;
    private LocalDateTime modified;
    static int parameter1 = 100;
    static int parameter2 = 10000;

    /**
     * Constructor for class Invoice
     * @param issuer invoice issuer
     * @param placeOfIssue the place where the invoice has been issued
     * @param created the date and time when the invoice was created
     * @param customer the buyer of the products
     * @param cashier the worker that sells the products
     * @param items all the items the buyer wants to have
     * @param typeOfPayment the way the buyer pays the invoice
     * @param paid amount of money that's been paid by the buyer
     * @param zoi invoice zoi number
     * @param eor invoice eor number
     * @param barcode invoice barcode number
     */
    public Invoice(Company issuer, String placeOfIssue, LocalDateTime created, Company customer, String cashier, Items items, String typeOfPayment, BigDecimal paid, String zoi, String eor, String barcode) {
        id = UUID.randomUUID();
        this.issuer = issuer;
        this.placeOfIssue = placeOfIssue;
        this.created = created;
        this.customer = customer;
        this.cashier = cashier;
        this.items = items;
        total = BigDecimal.ZERO;
        this.typeOfPayment = typeOfPayment;
        this.paid = paid;
        this.returned = BigDecimal.ZERO;
        invoiceNumber = calculateInvoiceNumber();
        this.zoi = zoi;
        this.eor = eor;
        this.barcode = barcode;
    }

    public UUID getId() {
        return id;
    }

    public Company getIssuer() {
        return issuer;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Company getCustomer() {
        return customer;
    }

    public String getCashier() {
        return cashier;
    }

    public Items getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public BigDecimal getReturned() {
        return returned;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getZoi() {
        return zoi;
    }

    public String getEor() {
        return eor;
    }

    public String getBarcode() {
        return barcode;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setIssuer(Company issuer) {
        this.issuer = issuer;
        modified = LocalDateTime.now();
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
        modified = LocalDateTime.now();
    }

    public void setCustomer(Company customer) {
        this.customer = customer;
        modified = LocalDateTime.now();
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
        modified = LocalDateTime.now();
    }

    public void setItems(Items items) {
        this.items = items;
        modified = LocalDateTime.now();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
        modified = LocalDateTime.now();
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
        modified = LocalDateTime.now();
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
        modified = LocalDateTime.now();
    }

    public void setReturned(BigDecimal returned) {
        this.returned = returned;
        modified = LocalDateTime.now();
    }

    public void setZoi(String zoi) {
        this.zoi = zoi;
        modified = LocalDateTime.now();
    }

    public void setEor(String eor) {
        this.eor = eor;
        modified = LocalDateTime.now();
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
        modified = LocalDateTime.now();
    }

    /**
     * The calculatePrice method calculates the whole amount to be paid (total)
     */
    public void calculatePrice() {
        for (Map.Entry<String, Item> entry: items.getItems().entrySet()) {
            Item i = entry.getValue();
            BigDecimal totalItemPrice = i.getPrice().multiply(i.getAmount());
            total = total.add(totalItemPrice);
        }
        returned = paid.subtract(total);
    }

    /**
     * The calculateInvoiceNumber method calculates invoice number on the base of 2 parameters
     */
    public String calculateInvoiceNumber() {
        parameter2++;
        if(parameter2 % 10==0){
            parameter1++;
        }
        String taxNumber = issuer.getTaxNumber();
        String invoiceNumber;
        invoiceNumber = taxNumber + '-' + parameter1 + '-' + parameter2;
        return invoiceNumber;
    }

    /**
     * The addItem method adds item directly to the invoice, calls method addItem from class Items
     */
    public void addItem(Item item){
        items.addItem(item);
    }

    /**
     * The removeItem method removes item directly from the invoice, calls method removeItem from class Items
     */
    public void removeItem(Item item){
        items.removeItem(item);
    }

    /**
     * The print method prints the whole invoice
    */
    public void print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = created.format(formatter);
        calculatePrice();
        System.out.println();
        System.out.println("Issuer: " + issuer.getName());
        System.out.println("Registration number: " + issuer.getRegistrationNumber());
        System.out.println("ID VAT: SI" + issuer.getTaxNumber());

        System.out.println("***************************************************************");
        if(customer != null) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Registration number: " + customer.getRegistrationNumber());
            if(customer.getTaxpayer()) {
                System.out.println("ID VAT: SI" + customer.getTaxNumber());
            }
        }
        System.out.println("***************************************************************");
        System.out.println(placeOfIssue + " " + formatDateTime + " " + cashier);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Item(s):");
        System.out.println("---------------------------------------------------------------");
        items.print();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total: " + total.setScale(2, RoundingMode.HALF_UP) + "€");
        System.out.println("Type of payment: " + typeOfPayment);
        System.out.println("Paid: " + paid + "€");
        if (typeOfPayment.equals("cash")) {
            System.out.println("Returned: " + returned.setScale(2, RoundingMode.HALF_UP) + "€");
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Invoice number: " + invoiceNumber);
        System.out.println("Issuer's trademark: " + zoi);
        System.out.println("Unique account identifier: " + eor);
        System.out.println("Barcode: " + barcode);
        System.out.println();
    }

    /**
     * The serach method returns true, if the object contains the String specified
     * in any instance variable.
     * @param string specified string
     */
    @Override
    public Boolean search(String string){
        return id.toString().contains(string) || issuer.search(string) || placeOfIssue.contains(string) ||
                created.toString().contains(string) || customer.search(string) || cashier.contains(string) || items.search(string) ||
                total.toString().contains(string) || typeOfPayment.contains(string) || paid.toString().contains(string) || returned.toString().contains(string) ||
                invoiceNumber.contains(string) || zoi.contains(string) || eor.contains(string) || barcode.contains(string) ||
                modified.toString().contains(string);
    }
}