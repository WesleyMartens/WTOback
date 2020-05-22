package server.service;

import org.springframework.stereotype.Service;
import server.entity.Address;
import server.entity.Product;
import server.repositories.AddressRepository;
import server.repositories.ProductRepository;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepo;

    public AddressServiceImpl(AddressRepository addressRepo) { this.addressRepo = addressRepo; }

    @Override
    public List<Address> findbyUserid(int userid) { return addressRepo.findByUser(userid); }

    @Override
    public void addressSave(Address address) {  addressRepo.save(address); }
}
