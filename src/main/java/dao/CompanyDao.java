package dao;

import model.Company;

import java.io.IOException;

public interface CompanyDao<O, D> extends DaoCrud<Company, O, D> {

    /**
     * method getByTaxNumber returns object by company tax number
     * @param taxNumber company tax number
     * @return Company object
     */
    Company getByTaxNumber(String taxNumber) throws IOException;

    /** method getByRegistrationNumber returns object by company registration number
     * @param registrationNumber company registration number
     * @return Company object
     */
    Company getByRegistrationNumber(String registrationNumber) throws IOException;
}
