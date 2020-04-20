package server.logic;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Component;
import server.entity.Address;
import server.entity.User;
import server.exceptions.LoginException;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;

import java.util.ArrayList;

@Component
public class AuthenticatieLogic implements IAuthenticatieLogic{
    private JwtLogic jwtLogic;

    public AuthenticatieLogic(JwtLogic jwtLogic) {
        this.jwtLogic = jwtLogic;
    }

    public void register(String name, String email, String password, int rolid, UserRepository userRepo) throws LoginException {
        if(!email.equals("") && !password.equals(""))
        {
            Argon2 argon = Argon2Factory.create();
            userRepo.save(new User(name,email, argon.hash(10, 65536, 1, password),rolid,new ArrayList<Address>()));
        }
        else {
            throw new LoginException("Hacking attempt deniëd");
        }
    }

    public String login(String email, String password, UserRepository userRepo) throws LoginException {
        User user = userRepo.findByEmail(email);
        if (user == null)
        {
            throw new LoginException("User not found");
        }
        Argon2 argon = Argon2Factory.create();
        if (argon.verify(user.getPassword(), password)) {
            return jwtLogic.generateJwt(user.getUserID(), user.getEmail());
        }
        throw new LoginException("Hacking attempt deniëd");
    }

    public VerifyResponse verify(String token, UserRepository userRepo) {
        return jwtLogic.verify(token);
    }
}
