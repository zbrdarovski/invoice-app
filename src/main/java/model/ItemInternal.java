package model;

import util.BarcodeUtil;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemInternal extends Item {
    private String department;
    private UUID internalId;
    private String barcode;

    public ItemInternal(Item item, String department) throws Exception {
        super(item.getBarcode(), item.getName(), item.getPrice(), item.getAmount(), item.getDiscount(), item.getVatRate());
        internalId = UUID.randomUUID();
        this.department = department;
        barcode = calculateInternalId(item);
    }

    public String calculateInternalId(Item item) throws Exception {
        String id = "";
        String barcode = item.getBarcode();
        BigDecimal amount = item.getAmount().multiply(new BigDecimal(1000));
        int amt = amount.intValue();
        int count = 0, num = amt;
        long sum = 0;

        while(num != 0)
        {
            num /= 10;
            ++count;
        }

        if(department == "fruit"){
            id += "200";
        }
        else if(department == "vegetable"){
            id += "201";
        }
        else if(department == "meat"){
            id += "202";
        }
        else if(department == "bake"){
            id += "203";
        }
        else {
            throw new Exception("False department, unable to calculate internalId!");
        }

        for(int i = 0; i < 4; i++){
            id+=barcode.charAt(i);
        }

        if(count == 1){
            id+= "0000";
            id+= amt;
        }
        else if(count == 2){
            id+= "000";
            id+= amt;
        }
        else if(count == 3){
            id+= "00";
            id+= amt;
        }
        else if(count == 4){
            id+= "0";
            id+= amt;
        }
        else if(count == 5){
            id+= amt;
        }
        else{
            throw new Exception("Amount is too large, unable to calculate internalId!");
        }

        for(int i = 0; i < id.length(); i++){
            if(i%2==0){
                sum += Character.getNumericValue(id.charAt(i));
            }
            else{
                sum += Character.getNumericValue(id.charAt(i))*3;
            }
        }

        long nearestEqualTen = ((sum + 9) / 10) * 10;

        long cd = nearestEqualTen - sum;
        id += cd;

        if(!BarcodeUtil.isBarcodeValid(id)){
            throw new Exception("Invalid barcode: " + id + "\n");
        }

        return id;
    }


    @Override
    public String toString() {
        return "ItemInternal{" +
                "department='" + department + '\'' +
                ", internalId=" + internalId +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}
