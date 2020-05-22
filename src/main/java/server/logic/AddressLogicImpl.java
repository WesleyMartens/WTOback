package server.logic;

import org.springframework.stereotype.Component;
import server.entity.Address;
import server.entity.User;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;
import server.service.AddressService;

import java.util.List;

@Component
public class AddressLogicImpl implements AddressLogic{
    private final AddressService addressService;

    private IAuthenticatieLogic authLogic;

    private UserRepository userRepo;

    public AddressLogicImpl(AddressService addressService, IAuthenticatieLogic authLogic,UserRepository userRepo) {
        this.addressService = addressService;
        this.authLogic = authLogic;
        this.userRepo = userRepo;
    }

    @Override
    public List<Address> findbyUserid(int userid) { return addressService.findbyUserid(userid); }

    public void addressSave(String token, String street, String zipcode, String city, String number, String country) {
        VerifyResponse user = authLogic.verify(token,userRepo);
        User user1 = new User(user.getId());
        addressService.addressSave(new Address(user1,street,zipcode,city,number,country));
    }
}
