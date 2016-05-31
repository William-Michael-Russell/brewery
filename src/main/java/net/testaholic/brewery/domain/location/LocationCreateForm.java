package net.testaholic.brewery.domain.location;

import net.testaholic.brewery.domain.user.Role;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by williamrussell on 5/20/16.
 */
public class LocationCreateForm {

    @NotEmpty
    private String storeTitle = "";

    @NotEmpty
    private String storeAddress = "";

    @NotEmpty
    private String storePhoneNumber = "";

    @NotEmpty
    private String storeEmail = "";

    @NotEmpty
    private String storeDescription = "";


    public LocationCreateForm(){

    }

    public LocationCreateForm(String title, String address, String storePhoneNumber, String storeEmail, String storeDescription) {
        this.storeTitle = title;
        this.storeAddress = address;
        this.storePhoneNumber = storePhoneNumber;
        this.storeEmail = storeEmail;
        this.storeDescription = storeDescription;
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
        return "LocationCreateForm{" +
                "storeTitle='" + storeTitle + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhoneNumber='" + storePhoneNumber + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                '}';
    }
}
