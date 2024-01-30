package def.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return this.machineRepository.findAll();
    }

    public Machine getById(Long id) {
        return this.machineRepository.findById(id).get();
    }

    public Machine createAndSave(String name) {
        Machine machine = new Machine(name);
        return this.save(machine);
    }
    public Machine save(Machine machine) {
        return this.machineRepository.save(machine);
    }
}
