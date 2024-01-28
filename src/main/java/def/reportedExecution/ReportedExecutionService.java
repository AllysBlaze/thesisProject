package def.reportedExecution;

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

    public ReportedExecution save(ReportedExecution reportedExecution) {
        return this.reportedExecutionRepository.save(reportedExecution);
    }
}
