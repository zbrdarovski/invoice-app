package dao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.CompanyDao;
import model.Company;
import util.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonCompany implements CompanyDao<List<Company>, JsonReader> {
    private final String filename = "src/main/resources/Company.json";

    @Override
    public Company getById(UUID id) throws IOException {
        List<Company> items = getAll();
        for (Company item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    @Override
    public List<Company> getAll() throws IOException {
        JsonReader reader = Util.readJsonFromFile(filename);
        return mapDataToObject(reader);
    }
    @Override
    public boolean insert(Company addedItem) throws IOException {
        Gson gson = new Gson();
        List<Company> items = getAll();
        if (items == null){
            items = new ArrayList<>();
        }
        for (Company item: items){
            if(item.getId().equals(addedItem.getId())) return false;
        }
        items.add(addedItem);
        return Util.writeJsonToFile(filename, gson.toJson(items));
    }
    @Override
    public boolean update(Company updatedItem) throws IOException {
        // TODO
        return false;
    }
    @Override
    public boolean delete(Company deletedItem) throws IOException {
        Gson gson = new Gson();
        List<Company> items = getAll();
        for (Company item : items) {
            if (item.getId().equals(deletedItem.getId())) {
                items.remove(item);
            }
        }
        return Util.writeJsonToFile(filename,gson.toJson(items));
    }
    @Override
    public List<Company> mapDataToObject(JsonReader data) throws IOException {
        Gson gson = new Gson();
        Type newType = new TypeToken<List<Company>>(){}.getType();
        return gson.fromJson(data, newType);
    }

    @Override
    public Company getByTaxNumber(String taxNumber) throws IOException {
        List<Company> items = getAll();
        for (Company item : items) {
            if (item.getTaxNumber().equals(taxNumber)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Company getByRegistrationNumber(String registrationNumber) throws IOException {
        List<Company> items = getAll();
        for (Company item : items) {
            if (item.getRegistrationNumber().equals(registrationNumber)) {
                return item;
            }
        }
        return null;
    }
}