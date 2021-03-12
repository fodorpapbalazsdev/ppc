package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiUserRegistrationRequest;
import fodorpapabalazsdev.ppc.service.role.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private PasswordEncoder passwordEncoder;
    private UserService userService;
    private RoleService roleService;

    @Override
    public User registrateUser(ApiUserRegistrationRequest apiUserRegistrationRequest) {
        /* Validate input */
        this.validateApiUserRegistrationRequest(apiUserRegistrationRequest);

        /* Check if email already exists */
        if (this.userService.checkIfEmailIsAlreadyTaken(apiUserRegistrationRequest.getEmail())) {
            throw new RequestRejectedException("Given email: " + apiUserRegistrationRequest.getEmail() + " is already in use.");
        }

        /* Check if name already exists */
        if (this.userService.checkIfNameIsAlreadyTaken(apiUserRegistrationRequest.getUsername())) {
            throw new RequestRejectedException("Given username: " + apiUserRegistrationRequest.getUsername() + " is already in use.");
        }

        User newUser = new User();
        newUser.setEmail(apiUserRegistrationRequest.getEmail());
        newUser.setUsername(apiUserRegistrationRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(apiUserRegistrationRequest.getPassword()));
        newUser.setRole(roleService.getRole("ROLE_USER"));
        return userService.adduser(newUser);
    }

    private void validateApiUserRegistrationRequest(ApiUserRegistrationRequest apiUserRegistrationRequest) {
        if (apiUserRegistrationRequest.getEmail() == null || apiUserRegistrationRequest.getEmail().isEmpty()) {
            throw new RequestRejectedException("Email is required for user registration!");
        }
        if (apiUserRegistrationRequest.getUsername() == null || apiUserRegistrationRequest.getUsername().isEmpty()) {
            throw new RequestRejectedException("Username is required for user registration!");
        }
        if (apiUserRegistrationRequest.getPassword() == null || apiUserRegistrationRequest.getPassword().isEmpty()) {
            throw new RequestRejectedException("Password is required for user registration!");
        }
    }
}
