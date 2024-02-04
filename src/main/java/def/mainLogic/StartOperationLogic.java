//package def.mainLogic;
//
//import def.employee.Employee;
//import def.machine.Machine;
//import def.machine.MachineService;
//import def.machine.MachineStatus;
//import def.operation.Operation;
//import def.operation.OperationService;
//import def.operation.OperationStatus;
//import def.reportedExecution.ReportedExecution;
//import def.reportedExecution.ReportedExecutionAction;
//import def.reportedExecution.ReportedExecutionService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class StartOperationLogic {
//
//    @Autowired
//    private ReportedExecutionService reportedExecutionService;
//
//    @Autowired
//    private MachineService machineService;
//
//    @Autowired
//    private OperationService operationService;
//
//    private Employee employee;
//
//    private Operation operation;
//    private Machine machine;
//
//    public void startOperation(Employee employee, Operation operation) throws Exception {
//        assignFields(employee, operation);
//        validate();
//        setStatuses();
//        saveObjects();
//    }
//
//    private void assignFields(Employee employee, Operation operation) {
//        this.employee = employee;
//        this.operation = operation;
//        machine = operation.getMachine();
//    }
//
//    private void validate() throws Exception {
//        List<ReportedExecution> reportedExecutionList = reportedExecutionService.getAll();
//        reportedExecutionList = reportedExecutionList.stream()
//                .filter(it -> Objects.equals(operation.getId(), it.getOperation().getId()))
//                .collect(Collectors.toList());
//        List<ReportedExecutionAction> reportedExecutionActionList = reportedExecutionList.stream()
//                .map(ReportedExecution::getReportedExecutionAction).toList();
//        if (reportedExecutionActionList.contains(ReportedExecutionAction.operationStart)) {
//            throw new Exception("operation already started");
//        }
//    }
//
//    private void setStatuses() {
//        machine.setMachineStatus(MachineStatus.working);
//        operation.setOperationStatus(OperationStatus.started);
//    }
//
//    private void saveObjects() {
//        reportedExecutionService.save(new ReportedExecution(0.0, employee, machine, operation, ReportedExecutionAction.operationStart));
//        machineService.save(machine);
//        operationService.save(operation);
//    }
//
//}
