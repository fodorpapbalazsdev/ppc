package fodorpapabalazsdev.ppc.entity;

import fodorpapabalazsdev.ppc.entity.ppc.Machine;
import fodorpapabalazsdev.ppc.entity.ppc.MagnetCylinder;
import fodorpapabalazsdev.ppc.exception.CylinderAlreadyAddedToMachine;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {


    @SneakyThrows
    @Test
    public void test() {
        Machine machine1 = new Machine("Name of the machine");

        assertEquals("Name of the machine", machine1.getName());

        assertNotNull(machine1.getCylinders());
        assertEquals(0, machine1.getCylinders().size());

        MagnetCylinder magnetCylinder = new MagnetCylinder(10, 2);
        machine1.addCylinder(magnetCylinder);
        assertThrows(CylinderAlreadyAddedToMachine.class, () -> machine1.addCylinder(magnetCylinder));
        assertEquals(1, machine1.getCylinders().size());

        MagnetCylinder magnetCylinder2 = new MagnetCylinder(20, 2);
        machine1.addCylinder(magnetCylinder2);
        assertEquals(2, machine1.getCylinders().size());
    }

}
