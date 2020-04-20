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
import server.repositories.AddressRepository;

import java.util.Map;

@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepo;

    public AddressController(){}

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/address/create")
    public ResponseEntity createAddress(@RequestBody Map<String, String> body){
        int userID = Integer.parseInt(body.get("userid"));
        String street = body.get("street");
        String zipcode = body.get("zipcode");
        String city = body.get("city");
        String number = body.get("number");
        String country = body.get("country");
        User user = new User(userID);
        try {
            addressRepo.save(new Address(user,street,zipcode,city,number,country));
            return new ResponseEntity(HttpStatus.OK);

        }catch (Exception ex) {
            this.logger.error("Creation failed");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
