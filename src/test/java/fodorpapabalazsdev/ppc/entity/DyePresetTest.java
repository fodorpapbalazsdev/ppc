package fodorpapabalazsdev.ppc.entity;

import fodorpapabalazsdev.ppc.entity.ppc.DyeCylinder;
import fodorpapabalazsdev.ppc.entity.ppc.DyePreset;
import fodorpapabalazsdev.ppc.entity.ppc.dye.Dye;
import fodorpapabalazsdev.ppc.exception.DyeAlreadyPresentInThisPreset;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DyePresetTest {

    @SneakyThrows
    @Test
    public void test() {
        DyePreset dyePreset = new DyePreset("Name of the DyePreset");

        assertEquals("Name of the DyePreset", dyePreset.getName());

        assertNotNull(dyePreset.getDyes());
        assertEquals(0, dyePreset.getDyes().size());

        Dye dye = new Dye("Dye Name", 2, new DyeCylinder(2, 1), 1);
        dyePreset.addDye(dye);
        assertEquals(1, dyePreset.getDyes().size());

        // Try to add the same dye -> should throw Exception
        assertThrows(DyeAlreadyPresentInThisPreset.class, () -> dyePreset.addDye(dye));
        assertEquals(1, dyePreset.getDyes().size());

        // Try to add a new dye
        Dye dye2 = new Dye("Dye Name 2", 2, new DyeCylinder(2, 1), 1);
        dyePreset.addDye(dye2);
        assertEquals(2, dyePreset.getDyes().size());
    }

}
