package fodorpapabalazsdev.ppc.entity.ppc;

import fodorpapabalazsdev.ppc.exception.CylinderAlreadyAddedToMachine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany()
    private List<MagnetCylinder> cylinders;

    public Machine(String nameOfTheMachine) {
        this.cylinders = new ArrayList<MagnetCylinder>();
        this.name = nameOfTheMachine;
    }

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
