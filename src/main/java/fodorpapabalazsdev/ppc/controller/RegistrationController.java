package fodorpapabalazsdev.ppc.controller;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiUserRegistrationRequest;
import fodorpapabalazsdev.ppc.response.ErrorResponse;
import fodorpapabalazsdev.ppc.service.user.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/auth/registration")
@AllArgsConstructor
public class RegistrationController {

    private UserRegistrationService userRegistrationService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody ApiUserRegistrationRequest apiUserRegistrationRequest) {
        return new ResponseEntity<>(userRegistrationService.registrateUser(apiUserRegistrationRequest), HttpStatus.OK);
    }

    @ExceptionHandler(RequestRejectedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(
            RequestRejectedException exception,
            WebRequest request
    ) {
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            HttpStatus httpStatus,
            WebRequest request
    ) {
        return buildErrorResponse(
                exception,
                exception.getMessage(),
                httpStatus,
                request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            String message,
            HttpStatus httpStatus,
            WebRequest request
    ) {
        ErrorResponse errorResponse = new ErrorResponse(
                httpStatus.value(),
                exception.getMessage()
        );

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}
