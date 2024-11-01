import dao.json.*;
import db.DatabaseUtil;
import model.*;
import util.BarcodeUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Item item1 = new Item("5462124476768", "SPAR TRAJNO MLEKO 3,5", new BigDecimal("0.77"), BigDecimal.ONE, new BigDecimal("0.00"), new BigDecimal("0.095"));
        Item item2 = new Item("3424565473432", "SPAR CIPS S SMET. 170G", new BigDecimal("0.96"), BigDecimal.ONE, new BigDecimal("0.00"), new BigDecimal("0.095"));
        Item item3 = new Item("9029857145932", "MONSTER ENERGY 500ML", new BigDecimal("1.18"), BigDecimal.ONE, new BigDecimal("0.00"), new BigDecimal("0.095"));
        LocalDateTime dateTime1 = LocalDateTime.of(2020, Month.MARCH, 3, 11, 58, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2020, Month.MARCH, 4, 17, 3, 0);
        LocalDateTime dateTime3 = LocalDateTime.of(2020, Month.MARCH, 6, 20, 43, 0);
        Company issuer1 = new Company("SPAR SLOVENIJA trgovsko podjetje d.o.o. Ljubljana", "32156782", "5571693000");
        Company customer1 = new Company("SUPER trgovina na drobno d.o.o.", "39294857", "1456233000");
        Company customer2 = new Company("MAXI družba za trgovino in storitve d.o.o.", "", "15768923000");

        Items items1 = new Items();
        Items items2 = new Items();
        Items items3 = new Items();

        Invoice invoice1 = new Invoice(issuer1, "Maribor", dateTime1, customer1, "Bl 151", items1, "cash", new BigDecimal("50"), "40ba076e64c94487d6fc72223389fcb2", "06a82a75-359c-4181-8cd7-25f8713e6860", "26400812165100476227200303115815");
        Invoice invoice2 = new Invoice(issuer1, "Maribor", dateTime2, customer2, "Bl 154", items2, "cash", new BigDecimal("1.20"), "da74f74ed1bd5e8e8d7f630035914c6a", "a2893481-bddc-4a61-73d0-3215e6795671", "26400812165400280059200304170342");
        Invoice invoice3 = new Invoice(issuer1, "Maribor", dateTime3, null, "Bl 153", items3, "cash", new BigDecimal("2.00"), "b9ac3f37f5615979d28a5ccaf25be793", "af661420-da22-43ac-865d-df7ab12eecfe", "26400812165300393071200306204358");

        invoice1.addItem(item1);
        invoice1.addItem(item1);
        invoice2.addItem(item2);
        invoice3.addItem(item3);
        invoice1.print();
        invoice2.print();
        invoice3.print();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Get Company Country From Barcode: ");
        System.out.println(BarcodeUtil.getCompanyCountryFromBarcode(item1.getBarcode()));
        System.out.println(BarcodeUtil.getCompanyCountryFromBarcode(item2.getBarcode()));
        System.out.println(BarcodeUtil.getCompanyCountryFromBarcode(item3.getBarcode()));
        System.out.println("---------------------------------------------------------------");

        JsonItem jsonItem = new JsonItem();
        jsonItem.insert(item1);
        jsonItem.insert(item2);
        System.out.println(jsonItem.getByBarcode(item1.getBarcode()));
        System.out.println(jsonItem.getById(item1.getId()));
        jsonItem.delete(item1);
        System.out.println(jsonItem.getAll());

        System.out.println("---------------------------------------------------------------");

        JsonItems jsonItems = new JsonItems();
        jsonItems.insert(items1);
        jsonItems.insert(items2);
        System.out.println(jsonItems.getById(items1.getId()));
        jsonItems.delete(items1);
        System.out.println(jsonItem.getAll());

        System.out.println("---------------------------------------------------------------");

        JsonInvoice jsonInvoice = new JsonInvoice();
        jsonInvoice.insert(invoice1);
        jsonInvoice.insert(invoice2);
        System.out.println(jsonInvoice.getById(invoice1.getId()));
        System.out.println(jsonInvoice.getByInvoiceNumber(invoice1.getInvoiceNumber()));
        System.out.println(jsonInvoice.getByBarcode(invoice1.getBarcode()));
        jsonInvoice.delete(invoice1);
        System.out.println(jsonItem.getAll());

        System.out.println("---------------------------------------------------------------");

        JsonCompany jsonCompany = new JsonCompany();
        jsonCompany.insert(customer1);
        jsonCompany.insert(customer2);
        System.out.println(jsonCompany.getById(customer1.getId()));
        System.out.println(jsonCompany.getByTaxNumber(customer1.getTaxNumber()));
        System.out.println(jsonCompany.getByRegistrationNumber(customer1.getRegistrationNumber()));
        jsonCompany.delete(customer1);
        System.out.println(jsonItem.getAll());

        System.out.println("---------------------------------------------------------------");

        Item item4 = new Item("6782940300238", "BANANE", new BigDecimal("1.2"), new BigDecimal("1.35"), new BigDecimal("0.00"), new BigDecimal("0.095"));
        ItemInternal iItem1 = new ItemInternal(item4, "fruit");

        Item item5 = new Item("8282309852456", "PARADIZNIK", new BigDecimal("1.99"), new BigDecimal("0.935"), new BigDecimal("0.00"), new BigDecimal("0.095"));
        ItemInternal iItem2 = new ItemInternal(item4, "vegetable");

        Item item6 = new Item("1009837800998", "PISCANEC", new BigDecimal("5.95"), new BigDecimal("1.2"), new BigDecimal("0.00"), new BigDecimal("0.095"));
        ItemInternal iItem3 = new ItemInternal(item4, "meat");

        Item item7 = new Item("9943112789443", "TORTA", new BigDecimal("15") , BigDecimal.ONE, new BigDecimal("0.00"), new BigDecimal("0.095"));
        ItemInternal iItem4 = new ItemInternal(item4, "bake");

        invoice1.addItem(item4);
        invoice1.addItem(item5);
        invoice1.addItem(item6);
        invoice1.addItem(item7);

        invoice1.print();

        System.out.println(iItem1.toString());
        System.out.println(iItem2.toString());
        System.out.println(iItem3.toString());
        System.out.println(iItem4.toString());

        System.out.println("---------------------------------------------------------------");

        DatabaseUtil.test("select * from language where language_id <= 3;");
    }
}