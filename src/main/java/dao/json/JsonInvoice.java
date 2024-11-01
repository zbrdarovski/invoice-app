package dao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.InvoiceDao;
import model.Invoice;
import util.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonInvoice implements InvoiceDao<List<Invoice>, JsonReader> {
    private final String filename = "src/main/resources/Invoice.json";

    @Override
    public Invoice getById(UUID id) throws IOException {
        List<Invoice> items = getAll();
        for (Invoice item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    @Override
    public List<Invoice> getAll() throws IOException {
        JsonReader reader = Util.readJsonFromFile(filename);
        return mapDataToObject(reader);
    }
    @Override
    public boolean insert(Invoice addedItem) throws IOException {
        Gson gson = new Gson();
        List<Invoice> items = getAll();
        if (items == null){
            items = new ArrayList<>();
        }
        for (Invoice item: items){
            if(item.getId().equals(addedItem.getId())) return false;
        }
        items.add(addedItem);
        return Util.writeJsonToFile(filename, gson.toJson(items));
    }
    @Override
    public boolean update(Invoice updatedItem) throws IOException {
        // TODO
        return false;
    }
    @Override
    public boolean delete(Invoice deletedItem) throws IOException {
        Gson gson = new Gson();
        List<Invoice> items = getAll();
        for (Invoice item : items) {
            if (item.getId().equals(deletedItem.getId())) {
                items.remove(item);
            }
        }
        return Util.writeJsonToFile(filename,gson.toJson(items));
    }
    @Override
    public List<Invoice> mapDataToObject(JsonReader data) throws IOException {
        Gson gson = new Gson();
        Type newType = new TypeToken<List<Invoice>>(){}.getType();
        return gson.fromJson(data, newType);
    }

    @Override
    public Invoice getByInvoiceNumber(String invoiceNumber) throws IOException {
        List<Invoice> items = getAll();
        for (Invoice item : items) {
            if (item.getInvoiceNumber().equals(invoiceNumber)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Invoice getByBarcode(String barcode) throws IOException {
        List<Invoice> items = getAll();
        for (Invoice item : items) {
            if (item.getBarcode().equals(barcode)) {
                return item;
            }
        }
        return null;
    }
}