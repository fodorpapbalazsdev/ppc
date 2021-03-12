package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.User;
import fodorpapabalazsdev.ppc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new ResourceAccessException("No User found in database");
        }
        return userList;
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceAccessException("No User found with the given id: " + id);
        }
        return user.get();
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new ResourceAccessException("No User found with the given email: " + email);
        }
        return user.get();
    }

    @Override
    public boolean checkIfEmailIsAlreadyTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean checkIfNameIsAlreadyTaken(String name) {
        return userRepository.findByName(name).isPresent();
    }

    @Override
    public User adduser(User newUser) {
        return userRepository.save(newUser);
    }
}
