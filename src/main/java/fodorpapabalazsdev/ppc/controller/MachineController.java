package fodorpapabalazsdev.ppc.controller;

import fodorpapabalazsdev.ppc.entity.Machine;
import fodorpapabalazsdev.ppc.service.machine.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@AllArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Machine>> getAll() {
        return new ResponseEntity<>(machineService.getMachines(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public ResponseEntity<Machine> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(machineService.getMachine(id), HttpStatus.OK);
    }
}
