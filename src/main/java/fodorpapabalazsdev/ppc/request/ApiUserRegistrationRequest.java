package fodorpapabalazsdev.ppc.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiUserRegistrationRequest {
    String email;
    String username;
    String password;
}
