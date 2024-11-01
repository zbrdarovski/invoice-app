package dao;

import model.ItemInternal;

import java.io.IOException;

public interface ItemInternalDao<O, D> extends DaoCrud<ItemInternal, O, D> {

    /** method getByBarcode returns object by ItemInternal barcode
     * return ItemInternal object
     */
    ItemInternal getByBarcode(String barcode) throws IOException;
}