package fodorpapabalazsdev.ppc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Material {
    private final String name;
    private final double price;

    public String toGuiString() {
        return String.format("%-35s %.3f %n", name, price);
    }
}
