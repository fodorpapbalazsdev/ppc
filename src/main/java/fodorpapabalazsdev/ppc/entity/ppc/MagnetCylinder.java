package fodorpapabalazsdev.ppc.entity.ppc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagnetCylinder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int teeth;
    private double girth;

    public MagnetCylinder(int teeth, double grith) {
        this.teeth = teeth;
        this.girth = grith;
    }

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
