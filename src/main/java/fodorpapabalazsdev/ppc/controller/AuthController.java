package fodorpapabalazsdev.ppc.controller;

import fodorpapabalazsdev.ppc.request.ApiLoginRequest;
import fodorpapabalazsdev.ppc.security.ApiResponse;
import fodorpapabalazsdev.ppc.security.ApiValidateTokenRequest;
import fodorpapabalazsdev.ppc.security.AuthService;
import fodorpapabalazsdev.ppc.security.JwtAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/generatetoken")
    public ResponseEntity<JwtAuthenticationResponse> generateToken(@RequestBody ApiLoginRequest loginRequest) {
        return ResponseEntity.ok(authService.getJwtAuthentication(loginRequest));
    }

    @PostMapping("/validatetoken")
    public ResponseEntity<ApiResponse> validateToken(@RequestBody ApiValidateTokenRequest apiValidateTokenRequest) {
        return ResponseEntity.ok(authService.validateToken(apiValidateTokenRequest));
    }
}
