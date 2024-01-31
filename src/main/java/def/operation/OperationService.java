package def.operation;

import def.machine.Machine;
import def.mainLogic.CalculateProducedQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAll() {
        return operationRepository.findAll();
    }

    public Operation getById(Long id) {
        return this.operationRepository.findById(id).get();
    }

    public Operation createAndSave(String name, Machine machine, Double plannedQuantity) {
        return this.operationRepository.save(new Operation(name, machine, plannedQuantity));
    }

    public Operation save(Operation operation) {
        operation.setNotifiedQuantity(CalculateProducedQuantity.calculateProducedQuantity(operation));
        operation.setPercentageRealized();
        return this.operationRepository.save(operation);
    }
}
