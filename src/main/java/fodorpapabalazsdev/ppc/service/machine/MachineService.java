package fodorpapabalazsdev.ppc.service.machine;

import fodorpapabalazsdev.ppc.entity.Machine;

import java.util.List;

public interface MachineService {
    List<Machine> getMachines();
    Machine getMachine(Integer id);
}
