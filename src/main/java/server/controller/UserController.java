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
import server.exceptions.LoginException;
import server.logic.IAuthenticatieLogic;
import server.repositories.UserRepository;
import server.responses.LoginResponse;
import server.responses.VerifyResponse;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepo;

    private IAuthenticatieLogic authlogic;

    public UserController(IAuthenticatieLogic authLogic) {
        this.authlogic = authLogic;
    }

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/user/register")
    public void register(@RequestBody Map<String, String> body) throws LoginException {
        String name = body.get("name");
        String email = body.get("email");
        String password = body.get("password");
        int rolID = 1;

        authlogic.register(name,email,password,rolID,userRepo);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");

        String token;
        try {
            token = authlogic.login(email, password,userRepo);
        } catch(LoginException ex) {
            this.logger.error("Authentication failed",ex);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<VerifyResponse> verify(@RequestBody Map<String, String> body){
        try {
            return new ResponseEntity<>(authlogic.verify(body.get("token"),userRepo), HttpStatus.OK);
        }catch (Exception ex) {
            this.logger.error("verification failed",ex);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
