package server.logic;

import server.dto.AddressDTO;
import server.entity.Address;

import java.util.List;

public interface AddressLogic {
    List<AddressDTO> findbyUserid(int userid);

    void addressSave(String token, String street, String zipcode, String city, String number, String country);
}
