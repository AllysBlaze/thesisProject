package def.mainLogic;

import def.operation.Operation;
import def.reportedExecution.ReportedExecution;
import def.reportedExecution.ReportedExecutionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalculateProducedQuantity {

    @Autowired
    private static ReportedExecutionService reportedExecutionService;

    public static Double calculateProducedQuantity(Operation operation) {
        Long operationId = operation.getId();
        List<ReportedExecution> reportedExecutionList = reportedExecutionService.getAll();
        reportedExecutionList = reportedExecutionList.stream()
                .filter(it -> Objects.equals(operationId, it.getOperation().getId()))
                .collect(Collectors.toList());
        return reportedExecutionList.stream()
                .map(ReportedExecution::getQuantity)
                .reduce(0.0, Double::sum);
    }

}
