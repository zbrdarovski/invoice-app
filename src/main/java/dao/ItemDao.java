package dao;

import model.Item;

import java.io.IOException;

public interface ItemDao<O, D> extends DaoCrud<Item, O, D> {

    /** method getByBarcode returns object by item barcode
     * @param barcode item barcode
     * @return Item object
     */
    Item getByBarcode(String barcode) throws IOException;
}
