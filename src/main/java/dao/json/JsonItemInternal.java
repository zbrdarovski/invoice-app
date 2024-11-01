package dao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.ItemInternalDao;
import model.ItemInternal;
import util.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonItemInternal implements ItemInternalDao<List<ItemInternal>, JsonReader> {
    private final String filename = "src/main/resources/ItemInternal.json";

    @Override
    public ItemInternal getById(UUID id) throws IOException {
        List<ItemInternal> items = getAll();
        for (ItemInternal item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    @Override
    public List<ItemInternal> getAll() throws IOException {
        JsonReader reader = Util.readJsonFromFile(filename);
        return mapDataToObject(reader);
    }
    @Override
    public boolean insert(ItemInternal addedItem) throws IOException {
        Gson gson = new Gson();
        List<ItemInternal> items = getAll();
        if (items == null){
            items = new ArrayList<>();
        }
        for (ItemInternal item: items){
            if(item.getId().equals(addedItem.getId())) return false;
        }
        items.add(addedItem);
        return Util.writeJsonToFile(filename, gson.toJson(items));
    }
    @Override
    public boolean update(ItemInternal updatedItem) throws IOException {
        // TODO
        return false;
    }
    @Override
    public boolean delete(ItemInternal deletedItem) throws IOException {
        Gson gson = new Gson();
        List<ItemInternal> items = getAll();
        for (ItemInternal item : items) {
            if (item.getId().equals(deletedItem.getId())) {
                items.remove(item);
            }
        }
        return Util.writeJsonToFile(filename,gson.toJson(items));
    }
    @Override
    public List<ItemInternal> mapDataToObject(JsonReader data) throws IOException {
        Gson gson = new Gson();
        Type newType = new TypeToken<List<ItemInternal>>(){}.getType();
        return gson.fromJson(data, newType);
    }

    @Override
    public ItemInternal getByBarcode(String barcode) throws IOException {
        List<ItemInternal> items = getAll();
        for (ItemInternal item : items) {
            if (item.getBarcode().equals(barcode)) {
                return item;
            }
        }
        return null;
    }
}