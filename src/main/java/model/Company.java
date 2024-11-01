package model;

import java.time.LocalDateTime;
import java.util.UUID;

/** Represents a company
 */
public class Company implements Searchable {
    private UUID id;
    private String name;
    private String taxNumber;
    private String registrationNumber;
    private Boolean taxpayer;
    private LocalDateTime created;
    private LocalDateTime modified;


    /**
     * Constructor for class Company
     * @param name company name
     * @param taxNumber company tax number
     * @param registrationNumber company registration number
     */
    public Company(String name, String taxNumber, String registrationNumber) {
        id = UUID.randomUUID();
        this.name = name;
        this.taxNumber = taxNumber;
        this.registrationNumber = registrationNumber;
        taxpayer = isTaxpayer();
        created = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Boolean getTaxpayer() {
        return taxpayer;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setName(String name) {
        this.name = name;
        modified = LocalDateTime.now();
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        modified = LocalDateTime.now();
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        modified = LocalDateTime.now();
    }

    /**
     * The serach method returns true, if the object contains the String specified
     * in any instance variable.
     * @param string specified string
     */
    @Override
    public Boolean search(String string) {
        return id.toString().contains(string) ||  name.contains(string) || taxNumber.contains(string) || registrationNumber.contains(string) ||
                created.toString().contains(string) ||modified.toString().contains(string);
    }

    /**
     * The isTaxpayer method returns true, if the company is a tax payer (has a tax number associated)
     */
    public Boolean isTaxpayer() {
        return !taxNumber.isEmpty();
    }

    /**
     * The toString returns information for the object
     * @return string that contains information about the whole object
     */
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", taxpayer=" + taxpayer +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
