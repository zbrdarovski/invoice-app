package model;

import util.BarcodeUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

/** Represents an item
 */
public class Item implements Searchable {
    private UUID id;
    private String barcode;
    private String name;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal discount;
    private BigDecimal vatRate;
    private LocalDateTime created;
    private LocalDateTime modified;

    /**
     * Constructor for Class Item
     * @param barcode item barcode
     * @param name item name
     * @param price item price
     * @param amount item amount
     * @param discount item discount
     * @param vatRate item VAT rate
     */
    public Item(String barcode, String name, BigDecimal price, BigDecimal amount, BigDecimal discount, BigDecimal vatRate) throws Exception {
        if(barcode.length()!=13){
            throw new Exception("Invalid barcode length: " + barcode + "\n");
        }

        if(!BarcodeUtil.isBarcodeValid(barcode)){
            throw new Exception("Invalid barcode: " + barcode + "\n");
        }

        id = UUID.randomUUID();
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.discount = discount;
        this.vatRate = vatRate;
        calculateItemTotal();
        created = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
        modified = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
        modified = LocalDateTime.now();
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        calculateItemTotal();
        modified = LocalDateTime.now();
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
        modified = LocalDateTime.now();
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
        modified = LocalDateTime.now();
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
        modified = LocalDateTime.now();
    }

    /**
     * The calculateItemTotal method calculates total price for the item
     */
    private void calculateItemTotal() {
        BigDecimal discountedItemPrice;
        discountedItemPrice = price.multiply(discount);
        price = price.subtract(discountedItemPrice);
        BigDecimal vattedItemPrice;
        vattedItemPrice = price.multiply(vatRate);
        price = price.add(vattedItemPrice);
    }

    /**
     * The print method prints the item details
     */
    public void print() {
        System.out.println(name + " " + amount + " " + price.setScale(2, RoundingMode.HALF_UP) + "€ " + discount + "€ " + price.multiply(amount).setScale(2, RoundingMode.HALF_UP) + "€");
    }

    /**
     * The serach method returns true, if the object contains the String specified
     * in any instance variable.
     * @param string specified string
     */
    @Override
    public Boolean search (String string){
        return id.toString().contains(string) || barcode.contains(string)  || name.contains(string) || price.toString().contains(string) ||
                amount.toString().contains(string) || discount.toString().contains(string) || vatRate.toString().contains(string) ||  created.toString().contains(string) ||
                modified.toString().contains(string);
    }
}