package fodorpapabalazsdev.ppc.service.role;

import fodorpapabalazsdev.ppc.entity.general.Role;
import fodorpapabalazsdev.ppc.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        List<Role> roleList = roleRepository.findAll();
        if (roleList.isEmpty()) {
            throw new ResourceAccessException("No Role found in database");
        }
        return roleList;
    }

    @Override
    public Role getRole(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new ResourceAccessException("No Role found with the given id: " + id);
        }
        return role.get();
    }

    @Override
    public Role getRole(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            throw new ResourceAccessException("No Role found with the given name: " + name);
        }
        return role.get();
    }
}
