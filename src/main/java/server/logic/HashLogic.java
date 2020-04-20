package server.logic;

import org.mindrot.jbcrypt.BCrypt;

import java.util.UUID;

public class HashLogic {
    public String hashPassword(String passwordPlaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(passwordPlaintext, salt);
    }
    public boolean checkPassword(String password_plaintext, String storedHash) {
        boolean passwordVerified = false;

        if(null == storedHash || !storedHash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");

        passwordVerified = BCrypt.checkpw(password_plaintext, storedHash);

        return(passwordVerified);
    }

    public String createRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
