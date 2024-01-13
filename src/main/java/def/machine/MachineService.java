package def.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAllMachines() {
        return this.machineRepository.findAll();
    }

    public Machine getMachineById(Long id) {
        return this.machineRepository.findById(id).get();
    }

    public Machine saveMachine(Machine machine) {
        return this.machineRepository.save(machine);
    }
}
