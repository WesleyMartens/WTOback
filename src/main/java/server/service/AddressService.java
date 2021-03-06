package server.service;

import server.dto.AddressDTO;
import server.entity.Address;
import server.entity.Product;

import java.util.List;

public interface AddressService {
    List<AddressDTO> findbyUserid(int userid);
    void addressSave(Address address);
}
