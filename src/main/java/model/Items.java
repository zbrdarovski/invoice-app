package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/** Represents a group of items
 */
public class Items implements Searchable {
    private UUID id;
    private LinkedHashMap<String, Item> items;
    private LocalDateTime created;
    private LocalDateTime modified;

    /** Constructor for class Items
     */
    public Items() {
        id = UUID.randomUUID();
        items = new LinkedHashMap < >();
        created = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public LinkedHashMap<String, Item> getItems() {
        return items;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setItems(LinkedHashMap<String, Item> items) {
        this.items = items;
        modified = LocalDateTime.now();
    }

    /**
     * The addItem method adds an item to the variable LinkedHashMap<String, Item> items
     */
    public void addItem(Item item) {
        if (items.containsKey(item.getBarcode())) {
            item.setAmount(item.getAmount().add(item.getAmount()));
        } else {
            items.put(item.getBarcode(), item);
            item.setAmount(item.getAmount());
        }
        modified = LocalDateTime.now();
    }

    /**
     * The removeItem method removes an item to the variable LinkedHashMap<String, Item> items
     */
    public void removeItem(Item item) {
        if (items.containsKey(item.getBarcode())) {
            if (item.getAmount().compareTo(new BigDecimal("1")) == 0) {
                items.remove(item.getBarcode(), item);
            } else {
                item.setAmount(item.getAmount().subtract(item.getAmount()));
            }
        }
        modified = LocalDateTime.now();
    }

    public void print() {
        for (Map.Entry<String, Item> entry: items.entrySet()) {
            Item i = entry.getValue();
            i.print();
        }
    }

    /**
     * The serach method returns true, if the object contains the String specified
     * in any instance variable.
     * @param string specified string
     */
    @Override
    public Boolean search (String string){
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            Item value = entry.getValue();
            if(value.search(string)){
                return true;
            }
        }
        return false;
    }
}