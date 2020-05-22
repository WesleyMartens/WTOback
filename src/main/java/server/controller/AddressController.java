package server.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Address;
import server.entity.User;
import server.logic.AddressLogic;
import server.logic.IAuthenticatieLogic;
import server.repositories.AddressRepository;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;


import java.util.Map;
import java.util.List;

@RestController
public class AddressController {
    private final AddressLogic addressLogic;

    @Autowired
    AddressRepository addressRepo;

    @Autowired
    UserRepository userRepo;

    private IAuthenticatieLogic authLogic;

    public AddressController(IAuthenticatieLogic authLogic, AddressLogic addressLogic) {
        this.authLogic = authLogic;
        this.addressLogic = addressLogic;
    }

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/address/create")
    public ResponseEntity createAddress(@RequestBody Map<String, String> body,@RequestHeader (name="Token") String token){
        String street = body.get("street");
        String zipcode = body.get("zipcode");
        String city = body.get("city");
        String number = body.get("number");
        String country = body.get("country");
        try {
            addressLogic.addressSave(token,street,zipcode,city,number,country);
            return new ResponseEntity(HttpStatus.OK);

        }catch (Exception ex) {
            this.logger.error("Creation failed");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/address/")
    public List<Address> getAddress(@RequestHeader (name="Token") String token){
        VerifyResponse user = authLogic.verify(token,userRepo);
        return addressLogic.findbyUserid(user.getId());
    }
}
