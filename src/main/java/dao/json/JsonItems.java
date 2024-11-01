package dao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.ItemsDao;
import model.Items;
import util.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonItems implements ItemsDao<List<Items>, JsonReader> {
    private final String filename = "src/main/resources/Items.json";

    @Override
    public Items getById(UUID id) throws IOException {
        List<Items> items = getAll();
        for (Items item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    @Override
    public List<Items> getAll() throws IOException {
        JsonReader reader = Util.readJsonFromFile(filename);
        return mapDataToObject(reader);
    }
    @Override
    public boolean insert(Items addedItem) throws IOException {
        Gson gson = new Gson();
        List<Items> items = getAll();
        if (items == null){
            items = new ArrayList<>();
        }
        for (Items item: items){
            if(item.getId().equals(addedItem.getId())) return false;
        }
        items.add(addedItem);
        return Util.writeJsonToFile(filename, gson.toJson(items));
    }
    @Override
    public boolean update(Items updatedItem) throws IOException {
        // TODO
        return false;
    }
    @Override
    public boolean delete(Items deletedItem) throws IOException {
        Gson gson = new Gson();
        List<Items> items = getAll();
        for (Items item : items) {
            if (item.getId().equals(deletedItem.getId())) {
                items.remove(item);
            }
        }
        return Util.writeJsonToFile(filename,gson.toJson(items));
    }
    @Override
    public List<Items> mapDataToObject(JsonReader data) throws IOException {
        Gson gson = new Gson();
        Type newType = new TypeToken<List<Items>>(){}.getType();
        return gson.fromJson(data, newType);
    }
}