package Authenticatie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import server.entity.User;
import server.exceptions.LoginException;
import server.logic.AuthenticatieLogic;
import server.logic.JwtLogic;
import server.repositories.UserRepository;


public class AuthenticatieLogicTests {
    @InjectMocks
    private AuthenticatieLogic authenticatieLogic;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtLogic jwtLogic;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        User loginRequest = new User();
        loginRequest.setUserID(1);
        loginRequest.setEmail("admin@hotmail.com");
        loginRequest.setPassword("admin");
        loginRequest.setPassword("$argon2i$v=19$m=65536,t=10,p=1$FAlwcZQ5liOd5brAR5nRfg$TTAy2gFIvDdqyu+Gfu0KI3qzQZbDxrp1h7lo5LBc4fA");
        Mockito.when(userRepository.findByEmail("admin@hotmail.com")).thenReturn(loginRequest);
    }


    @Test
    public void loginTrue(){
        Assertions.assertDoesNotThrow(() -> authenticatieLogic.login("admin@hotmail.com","admin",userRepository));
    }

    @Test
    public void loginEmailFalse(){
        Assertions.assertThrows(LoginException.class, () -> authenticatieLogic.login("admin","admin",userRepository));
    }

    @Test
    public void loginPasswordFalse(){
        Assertions.assertThrows(LoginException.class, () -> authenticatieLogic.login("admin","test",userRepository));
    }

    @Test
    public void registerPlayerTrue(){
       Assertions.assertDoesNotThrow(() -> authenticatieLogic.register("admin","admin@hotmail.com","admin",1,userRepository));
    }

    @Test
    public void registerPlayerEmailFalse()
    {
        Assertions.assertThrows(LoginException.class, () -> authenticatieLogic.register("admin","","admin",1,userRepository));
    }

    @Test
    public void registerPlayerPasswordFalse()
    {
        Assertions.assertThrows(LoginException.class, () -> authenticatieLogic.register("admin","admin@hotmail.com","",1,userRepository));
    }

    @Test
    public void verifyJwtTokenTrue() throws LoginException {
        User user = new User();
        user.setUserID(1);
        user.setEmail("admin@hotmail.com");
        user.setPassword("admin");
        String token = authenticatieLogic.login(user.getEmail(),user.getPassword(),userRepository);
        Assertions.assertDoesNotThrow(() -> authenticatieLogic.verify(token,userRepository));
    }
}
