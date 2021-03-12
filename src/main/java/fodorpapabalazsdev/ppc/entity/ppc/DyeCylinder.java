package fodorpapabalazsdev.ppc.entity.ppc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class DyeCylinder {
    private final double volume;
    private final int percent;

    @Override
    public String toString() {
        return String.valueOf(volume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DyeCylinder that = (DyeCylinder) o;
        return Double.compare(that.volume, volume) == 0 && percent == that.percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, percent);
    }
}
