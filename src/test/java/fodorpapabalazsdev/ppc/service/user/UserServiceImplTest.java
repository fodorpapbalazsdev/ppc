package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void getUsersShouldReturnUsers() {
        /* Mock */
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setUsername("User 1");

        User user2 = new User();
        user2.setUsername("User 2");

        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        /* Call */
        List<User> userList = userService.getUsers();

        /* Assert */
        assertEquals(2, userList.size());
        assertEquals("User 1", userList.get(0).getUsername());
        assertEquals("User 2", userList.get(1).getUsername());
    }

    @Test
    public void getUsersShouldThrowException() {
        /* Mock */
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        /* Call & Assert */
        assertThrows(ResourceAccessException.class, () -> userService.getUsers());
    }

    @Test
    public void getUserShouldReturnUser() {
        /* Mock */
        User user1 = new User();
        user1.setUsername("User 1");

        when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        /* Call */
        User user = userService.getUser(1);

        /* Assert */
        assertEquals("User 1", user.getUsername());
    }

    @Test
    public void getUserShouldThrowException() {
        /* Mock */
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        /* Call & Assert */
        assertThrows(ResourceAccessException.class, () -> userService.getUser(1));
    }

    @Test
    public void getUserByEmalShouldReturnUser() {
        /* Mock */
        User user1 = new User();
        user1.setUsername("User 1");
        user1.setEmail("user@user.com");

        when(userRepository.findByEmail("user@user.com")).thenReturn(Optional.of(user1));

        /* Call */
        User user = userService.getUserByEmail("user@user.com");

        /* Assert */
        assertEquals("User 1", user.getUsername());
        assertEquals("user@user.com", user.getEmail());
    }

    @Test
    public void getUserByEmailShouldThrowException() {
        /* Mock */
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        /* Call & Assert */
        assertThrows(ResourceAccessException.class, () -> userService.getUserByEmail("asd"));
    }
}
