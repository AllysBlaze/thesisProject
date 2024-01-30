package def.reportedExecution;

import def.employee.Employee;
import def.machine.Machine;
import def.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportedExecutionService {

    @Autowired
    private ReportedExecutionRepository reportedExecutionRepository;

    public List<ReportedExecution> getAll() {
        return this.reportedExecutionRepository.findAll();
    }

    public ReportedExecution getById(Long id) {
        return this.reportedExecutionRepository.findById(id).get();
    }

    public ReportedExecution createAndSave(Double quantity, Employee employee, Machine machine, Operation operation) {
        return this.reportedExecutionRepository.save(new ReportedExecution(quantity, employee, machine, operation));
    }

    public ReportedExecution save(ReportedExecution reportedExecution) {
        return this.reportedExecutionRepository.save(reportedExecution);
    }
}
