package fodorpapabalazsdev.ppc.service.user;

import fodorpapabalazsdev.ppc.entity.general.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Integer id);

    User getUserByEmail(String email);

    boolean checkIfEmailIsAlreadyTaken(String email);

    boolean checkIfNameIsAlreadyTaken(String username);

    User adduser(User newUser);
}
