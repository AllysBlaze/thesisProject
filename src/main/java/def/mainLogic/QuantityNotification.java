//package def.mainLogic;
//
//import def.employee.Employee;
//import def.machine.Machine;
//import def.machine.MachineService;
//import def.operation.Operation;
//import def.operation.OperationService;
//import def.reportedExecution.ReportedExecution;
//import def.reportedExecution.ReportedExecutionAction;
//import def.reportedExecution.ReportedExecutionService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class QuantityNotification {
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
//    public void notifyQuantity(Employee employee, Operation operation, Double quantity) {
//        assignFields(employee, operation);
//        createReportedExecution(quantity);
//    }
//
//    private void assignFields(Employee employee, Operation operation) {
//        this.employee = employee;
//        this.operation = operation;
//        machine = operation.getMachine();
//    }
//
//    private void createReportedExecution(Double quantity) {
//        ReportedExecution reportedExecution = new ReportedExecution(quantity, employee, machine, operation, ReportedExecutionAction.quantityNotification);
//        reportedExecutionService.save(reportedExecution);
//        operationService.save(operation);
//    }
//}
