package fodorpapabalazsdev.ppc.entity.ppc;

import fodorpapabalazsdev.ppc.entity.ppc.dye.Dye;
import fodorpapabalazsdev.ppc.exception.DyeAlreadyPresentInThisPreset;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class DyePreset {

    private final String name;
    private final List<Dye> dyes = new ArrayList<>();

    public void addDye(Dye dye) throws DyeAlreadyPresentInThisPreset {
        if (!dyes.contains(dye)) {
            this.dyes.add(dye);
        } else {
            throw new DyeAlreadyPresentInThisPreset(this, dye);
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
