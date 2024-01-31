package def;

import def.employee.Employee;
import def.machine.Machine;
import def.mainLogic.StartOperationLogic;
import def.operation.Operation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class OperationLifeCycleTest {

    @Test
    void startAndNotifyQuantity() throws Exception {
        Employee employee = new Employee(55L,"name","surname");
        Machine machine = new Machine(43L,"cnc01");
        Operation operation = new Operation(22L,"op1",machine,33.0);

        StartOperationLogic startOperationLogic = new StartOperationLogic();
        startOperationLogic.startOperation(employee,operation);
    }

}
