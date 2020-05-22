package server.logic;

import server.entity.Address;

import java.util.List;

public interface AddressLogic {
    List<Address> findbyUserid(int userid);

    void addressSave(String token, String street, String zipcode, String city, String number, String country);
}
