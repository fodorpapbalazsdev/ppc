package fodorpapabalazsdev.ppc.security;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private static final String TOKEN_TYPE = "Bearer";

    private String accessToken;
    private String role;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
