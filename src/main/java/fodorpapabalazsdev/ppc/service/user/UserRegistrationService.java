package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiUserRegistrationRequest;

public interface UserRegistrationService {
    User registrateUser(ApiUserRegistrationRequest apiUserRegistrationRequest);
}
