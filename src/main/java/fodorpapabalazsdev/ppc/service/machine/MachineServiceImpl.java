package fodorpapabalazsdev.ppc.service.machine;

import fodorpapabalazsdev.ppc.entity.ppc.Machine;
import fodorpapabalazsdev.ppc.repository.MachineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;

    @Override
    public List<Machine> getMachines() {
        List<Machine> machineList = machineRepository.findAll();
        if (machineList.isEmpty()) {
            throw new ResourceAccessException("No Machine found in database");
        }
        return machineList;
    }

    @Override
    public Machine getMachine(Integer id) {
        Optional<Machine> machine = machineRepository.findById(id);
        if (machine.isEmpty()) {
            throw new ResourceAccessException("No Machine found with the given id: " + id);
        }
        return machine.get();
    }
}
