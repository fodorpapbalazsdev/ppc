package fodorpapabalazsdev.ppc.service.machine;

import fodorpapabalazsdev.ppc.entity.ppc.Machine;
import fodorpapabalazsdev.ppc.repository.MachineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.ResourceAccessException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MachineServiceImplTest {

    private static final List<Machine> MACHINES = Arrays.asList(new Machine("Dummy"), new Machine("Dummy2"));
    @Mock
    MachineRepository machineRepository;

    @InjectMocks
    MachineServiceImpl machineService;

    @Test
    public void getMachinesShouldReturnMachines() {
        /* Mock */
        when(machineRepository.findAll()).thenReturn(MACHINES);

        /* Call */
        List<Machine> machineList = machineService.getMachines();

        /* Assert */
        assertEquals(2, machineList.size());
        assertEquals("Dummy", machineList.get(0).getName());
        assertEquals("Dummy2", machineList.get(1).getName());
    }

    @Test
    public void getMachinesShouldThrowException() {
        /* Mock */
        when(machineRepository.findAll()).thenReturn(Collections.emptyList());

        /* Call & Assert */
        assertThrows(ResourceAccessException.class, () -> machineService.getMachines());
    }

}
