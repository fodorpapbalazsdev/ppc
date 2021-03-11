package fodorpapabalazsdev.ppc.entity;

import fodorpapabalazsdev.ppc.exception.CylinderAlreadyAddedToMachine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@AllArgsConstructor
public class Machine {
    private final String name;
    private final List<MagnetCylinder> cylinders = new ArrayList<MagnetCylinder>();

    public void addCylinder(MagnetCylinder cylinder) throws CylinderAlreadyAddedToMachine {
        if (!cylinders.contains(cylinder)) {
            this.cylinders.add(cylinder);
        } else {
            throw new CylinderAlreadyAddedToMachine(this, cylinder);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return name.equals(machine.name) && cylinders.equals(machine.cylinders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cylinders);
    }
}
