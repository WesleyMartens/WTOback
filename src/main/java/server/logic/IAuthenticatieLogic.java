package server.logic;

import server.exceptions.LoginException;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;

public interface IAuthenticatieLogic {

    void register(String name,String email, String password, int rolid, UserRepository userRepo) throws LoginException;

    String login(String email, String password, UserRepository userRepo) throws LoginException;

    VerifyResponse verify(String token, UserRepository userRepo);
}
