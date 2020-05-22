package server.service;

import server.entity.Address;
import server.entity.Product;

import java.util.List;

public interface AddressService {
    List<Address> findbyUserid(int userid);
    void addressSave(Address address);
}
