package dao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.ItemDao;
import model.Item;
import util.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonItem implements ItemDao<List<Item>, JsonReader> {
    private final String filename = "src/main/resources/Item.json";

    @Override
    public Item getById(UUID id) throws IOException {
        List<Item> items = getAll();
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    @Override
    public List<Item> getAll() throws IOException {
        JsonReader reader = Util.readJsonFromFile(filename);
        return mapDataToObject(reader);
    }
    @Override
    public boolean insert(Item addedItem) throws IOException {
        Gson gson = new Gson();
        List<Item> items = getAll();
        if (items == null){
            items = new ArrayList<>();
        }
        for (Item sez: items){
            if(sez.getId().equals(addedItem.getId())) return false;
        }
        items.add(addedItem);
        return Util.writeJsonToFile(filename, gson.toJson(items));
    }
    @Override
    public boolean update(Item updatedItem) throws IOException {
        // TODO
        return false;
    }
    @Override
    public boolean delete(Item deletedItem) throws IOException {
        Gson gson = new Gson();
        List<Item> items = getAll();
        for (Item item : items) {
            if (item.getId().equals(deletedItem.getId())) {
                items.remove(item);
            }
        }
        return Util.writeJsonToFile(filename,gson.toJson(items));
    }
    @Override
    public List<Item> mapDataToObject(JsonReader data) throws IOException {
        Gson gson = new Gson();
        Type newType = new TypeToken<List<Item>>(){}.getType();
        return gson.fromJson(data, newType);
    }

    @Override
    public Item getByBarcode(String barcode) throws IOException {
        List<Item> items = getAll();
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                return item;
            }
        }
        return null;
    }
}