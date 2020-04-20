package server.responses;

import lombok.Data;

@Data
public class VerifyResponse {
    private int id;
    private String email;

    public VerifyResponse(int id, String email) {
        this.id = id;
        this.email = email;
    }
}
