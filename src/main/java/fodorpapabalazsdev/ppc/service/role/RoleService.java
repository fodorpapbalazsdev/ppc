package fodorpapabalazsdev.ppc.service.role;


import fodorpapabalazsdev.ppc.entity.general.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Role getRole(Integer id);

    Role getRole(String name);
}
