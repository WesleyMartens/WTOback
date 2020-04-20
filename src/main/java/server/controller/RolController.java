package server.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Rol;
import server.repositories.RolRepository;

import java.util.Map;

@RestController
public class RolController {
    @Autowired
    RolRepository rolRepo;

    public RolController() { }

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/rol/create")
    public ResponseEntity register(@RequestBody Map<String, String> body)  {
        String name = body.get("name");
        try {
            rolRepo.save(new Rol(name));
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception ex)
        {
            this.logger.error("creation of rol failed",ex);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
