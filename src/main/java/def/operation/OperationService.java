package def.operation;

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

    public Operation save(Operation operation) {
        return this.operationRepository.save(operation);
    }
}
