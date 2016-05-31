package net.testaholic.brewery.domain.location;

import javax.persistence.*;

/**
 * Created by williamrussell on 5/20/16.
 */
@Entity
@Table(name = "location")
public class Location {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "store_title", nullable = false, length = 25, unique = true)
    private String storeTitle;

    @Column(name = "store_address", nullable = false, length = 75, unique = true)
    private String storeAddress;

    @Column(name = "phone_number", nullable = false)
    private String storePhoneNumber;

    @Column(name = "store_email", nullable = false)
    private String storeEmail;

    @Column(name = "store_description", nullable = false)
    private String storeDescription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public void setStoreTitle(String storeTitle) {
        this.storeTitle = storeTitle;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", storeTitle='" + storeTitle + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhoneNumber='" + storePhoneNumber + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                '}';
    }
}
