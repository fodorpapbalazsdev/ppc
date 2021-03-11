package fodorpapabalazsdev.ppc.exception;

import fodorpapabalazsdev.ppc.entity.Machine;
import fodorpapabalazsdev.ppc.entity.MagnetCylinder;

public class CylinderAlreadyAddedToMachine extends Exception {
    public CylinderAlreadyAddedToMachine(Machine machine, MagnetCylinder magnetCylinder) {
        super("MagnetCylinder " + magnetCylinder + " already added to the following Machine: " + machine.getName());
    }
}
