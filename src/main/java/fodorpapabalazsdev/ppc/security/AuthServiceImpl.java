package fodorpapabalazsdev.ppc.security;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiLoginRequest;
import fodorpapabalazsdev.ppc.security.jwt.JwtTokenProvider;
import fodorpapabalazsdev.ppc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @Override
    public JwtAuthenticationResponse getJwtAuthentication(ApiLoginRequest apiLoginRequest) {

        if (apiLoginRequest.getPassword() == null || apiLoginRequest.getEmail() == null) {
            throw new ResourceAccessException("Email and Password is required for token generation");
        }

        String jwt = jwtTokenProvider.generateToken(apiLoginRequest);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
        User user = userService.getUserByEmail(apiLoginRequest.getEmail());

        /* check it's password */
        if (!user.getPassword().equals(apiLoginRequest.getPassword())) {
            throw new ResourceAccessException("Password is incorrect for user: " + user);
        }

        jwtAuthenticationResponse.setRole(user.getRole().getName());

        return jwtAuthenticationResponse;
    }

    @Override
    public ApiResponse validateToken(ApiValidateTokenRequest apiValidateTokenRequest) {
        if (apiValidateTokenRequest.getToken() == null) {
            throw new ResourceAccessException("Token is required for token validation!");
        }

        String jwt = apiValidateTokenRequest.getToken();
        if (jwtTokenProvider.validateToken(jwt)) {
            String email = jwtTokenProvider.getEmailFromJwt(jwt);
            userService.getUserByEmail(email);
            return new ApiResponse(Boolean.TRUE, "Valid token for email " + email);
        }
        return new ApiResponse(Boolean.FALSE, "Invalid token");
    }
}
