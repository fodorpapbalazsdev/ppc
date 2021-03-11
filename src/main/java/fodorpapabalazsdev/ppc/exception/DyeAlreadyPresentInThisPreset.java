package fodorpapabalazsdev.ppc.exception;

import fodorpapabalazsdev.ppc.entity.dye.Dye;
import fodorpapabalazsdev.ppc.entity.DyePreset;

public class DyeAlreadyPresentInThisPreset extends Exception {
    public DyeAlreadyPresentInThisPreset(DyePreset dyePreset, Dye dye) {
        super("Dye with name: " + dye.getName() + " is already present in DyePreset: " + dyePreset.getName());
    }
}
