package fodorpapabalazsdev.ppc.security;

import fodorpapabalazsdev.ppc.request.ApiLoginRequest;

public interface AuthService {
    JwtAuthenticationResponse getJwtAuthentication(ApiLoginRequest apiLoginRequest);

    ApiResponse validateToken(ApiValidateTokenRequest apiValidateTokenRequest);
}
