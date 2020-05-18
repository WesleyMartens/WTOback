package Jwt;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import server.logic.JwtLogic;


public class JwtLogicTests {

    private String SECRET = "FvO64lrjbhE5DpsZOLq1K5EHeerPlETbfhy6wbemHA2A4mxRF2QXPwDiZJEHG6hd63LXLF9q44oSJEk";

    @InjectMocks
    private JwtLogic jwtLogic;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup()
    {
        objectMapper = new ObjectMapper();
        jwtLogic = new JwtLogic(objectMapper,SECRET);
    }

    @Test
    public void generateJwt()
    {
        Assertions.assertDoesNotThrow(() -> jwtLogic.generateJwt(1,"test"));
    }

    @Test
    public void verifyJwtTrue()
    {
        String token = jwtLogic.generateJwt(1,"email");
        Assertions.assertDoesNotThrow(() -> jwtLogic.verify(token));
    }

    @Test
    public void verifyeJwtFalse()
    {
        String token = "";
        Assertions.assertThrows(IllegalArgumentException.class ,() -> jwtLogic.verify(token));
    }
}
