package fodorpapabalazsdev.ppc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class MagnetCylinder {
    private final int teeth;
    private final double girth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagnetCylinder that = (MagnetCylinder) o;
        return teeth == that.teeth && Double.compare(that.girth, girth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teeth, girth);
    }
}
