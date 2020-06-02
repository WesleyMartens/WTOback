package server.dto;

import lombok.Data;
import server.entity.Address;

import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {

    private int addressID;


    @NotNull(message = "Please provide: description")
    private String street;

    @NotNull(message = "Please provide: description")
    private String zipcode;

    @NotNull(message = "Please provide: description")
    private String city;

    @NotNull(message = "Please provide: description")
    private String number;

    @NotNull(message = "Please provide: description")
    private String country;

    public AddressDTO(){
    }

    public AddressDTO(Address address){
        this.addressID = address.getAddressID();
        this.street = address.getStreet();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.number = address.getNumber();
        this.country = address.getCountry();
    }
}
