package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Generic interface for DAO
 */
public interface DaoCrud<T, O, D> {

    /** method getById returns an object by its id
     * @param id
     * @return T object
     */
    T getById(UUID id) throws IOException;

    /** method getAll returns all T objects
     * @return list of all T objects
     */
    List<T> getAll() throws IOException;

    /** method insert inserts an object
     * @param object generic object
     * @return true on success
     */
    boolean insert(T object) throws IOException;

    /** method update updates an object
     * @param object generic object
     * @return true on success
     */
    boolean update(T object) throws IOException;

    /** method delete deletes an object
     * @param object generic object
     * @return true on success
     */
    boolean delete(T object) throws IOException;

    /** method mapDataToObject maps data to object
     * @param data generic data
     */
    O mapDataToObject(D data) throws IOException;
}
