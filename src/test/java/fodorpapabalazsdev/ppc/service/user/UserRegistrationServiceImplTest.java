package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.Role;
import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.request.ApiUserRegistrationRequest;
import fodorpapabalazsdev.ppc.service.role.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.RequestRejectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceImplTest {

    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    UserService userService;
    @Mock
    RoleService roleService;

    @InjectMocks
    UserRegistrationServiceImpl userRegistrationService;

    @Test
    public void userRegistRationShouldReturnUser() {
        /* Mock */
        when(userService.checkIfEmailIsAlreadyTaken("email")).thenReturn(false);
        when(userService.checkIfNameIsAlreadyTaken("username")).thenReturn(false);
        User user = new User();
        user.setEmail("email");
        user.setUsername("username");
        when(userService.adduser(any())).thenReturn(user);
        when(passwordEncoder.encode("secret")).thenReturn("hashedsecret");
        when(roleService.getRole("ROLE_USER")).thenReturn(new Role("ROLE_USER"));

        ApiUserRegistrationRequest request = new ApiUserRegistrationRequest("email", "username", "secret");

        User result = userRegistrationService.registrateUser(request);
        assertEquals("email", result.getEmail());
        assertEquals("username", result.getUsername());
    }

    @Test
    public void userRegistRationShouldThrowExceptionIfGicenEmailAlreadyInUse() {
        /* Mock */
        when(userService.checkIfEmailIsAlreadyTaken("email")).thenReturn(true);

        /* Call & Assert */
        ApiUserRegistrationRequest request = new ApiUserRegistrationRequest("email", "username", "secret");
        assertThrows(RequestRejectedException.class, () -> userRegistrationService.registrateUser(request));
    }

    @Test
    public void userRegistRationShouldThrowExceptionIfGicenNameAlreadyInUse() {
        /* Mock */
        when(userService.checkIfEmailIsAlreadyTaken("email")).thenReturn(false);
        when(userService.checkIfNameIsAlreadyTaken("username")).thenReturn(true);

        /* Call & Assert */
        ApiUserRegistrationRequest request = new ApiUserRegistrationRequest("email", "username", "secret");
        assertThrows(RequestRejectedException.class, () -> userRegistrationService.registrateUser(request));
    }

}
