package fodorpapabalazsdev.ppc.exception;

import fodorpapabalazsdev.ppc.entity.ppc.DyePreset;
import fodorpapabalazsdev.ppc.entity.ppc.dye.Dye;

public class DyeAlreadyPresentInThisPreset extends Exception {
    public DyeAlreadyPresentInThisPreset(DyePreset dyePreset, Dye dye) {
        super("Dye with name: " + dye.getName() + " is already present in DyePreset: " + dyePreset.getName());
    }
}
