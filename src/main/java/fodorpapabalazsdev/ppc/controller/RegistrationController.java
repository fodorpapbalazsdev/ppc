package fodorpapabalazsdev.ppc.controller;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiUserRegistrationRequest;
import fodorpapabalazsdev.ppc.service.user.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/registration")
@AllArgsConstructor
public class RegistrationController {

    private UserRegistrationService userRegistrationService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody ApiUserRegistrationRequest apiUserRegistrationRequest) {
        return new ResponseEntity<>(userRegistrationService.registrateUser(apiUserRegistrationRequest), HttpStatus.OK);
    }
}
