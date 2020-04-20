package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import server.logic.AuthenticatieLogic;
import server.logic.IAuthenticatieLogic;
import server.logic.JwtLogic;
import server.repositories.UserRepository;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
private static final String SECRET = "FvO64lrjbhE5DpsZOLq1K5EHeerPlETbfhy6wbemHA2A4mxRF2QXPwDiZJEHG6hd63LXLF9q44oSJEkqRAYMYWf94bh0appZjYpJzsUSWV40zKOQmQXnZIPpzbAxqaxpAKLqQ9IhkoWpuhETounNJePPlUTaNC8D";

    @Bean
    public IAuthenticatieLogic authenticatieLogic(JwtLogic jwtLogic) {
        return new AuthenticatieLogic(jwtLogic);
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }

    @Bean
    public JwtLogic jwtLogic(ObjectMapper objectMapper)
    {
        return new JwtLogic(objectMapper, AppConfig.SECRET);
    }
}
