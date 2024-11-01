package dao;

import model.Invoice;

import java.io.IOException;

public interface InvoiceDao<O, D> extends DaoCrud<Invoice, O, D> {

    /** method getByInvoiceNumber returns object by invoice number
     * @param invoiceNumber invoice number
     * @return Invoice object
     */
    Invoice getByInvoiceNumber(String invoiceNumber) throws IOException;

    /** method getByBarcode returns object by invoice barcode
     * @param barcode invoice barcode
     * @return Invoice object
     */
    Invoice getByBarcode(String barcode) throws IOException;
}
