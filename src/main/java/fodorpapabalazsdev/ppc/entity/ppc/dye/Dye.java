package fodorpapabalazsdev.ppc.entity.dye;

import fodorpapabalazsdev.ppc.entity.DyeCylinder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Dye {
    protected final String name;
    protected final double price;
    protected final DyeCylinder dyeCylinder;
    protected final int cover;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dye dye = (Dye) o;
        return Double.compare(dye.price, price) == 0 && cover == dye.cover && name.equals(dye.name) && dyeCylinder.equals(dye.dyeCylinder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, dyeCylinder, cover);
    }
}
