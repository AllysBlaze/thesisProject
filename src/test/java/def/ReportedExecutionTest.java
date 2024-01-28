package def;

import def.employee.Employee;
import def.machine.Machine;
import def.operation.Operation;
import def.reportedExecution.ReportedExecution;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportedExecutionTest {

    @Test
    void getQuantity() {
        Machine machine = new Machine("name");
        Employee employee = new Employee();
        ReportedExecution reportedExecution = new ReportedExecution(11.0, employee, machine, new Operation());
        assertEquals(11, reportedExecution.getQuantity(), 0);
    }

    @Test
    void getEmployee() {
        Machine machine = new Machine("name");
        Employee employee = new Employee();
        ReportedExecution reportedExecution = new ReportedExecution(11.0, employee, machine, new Operation());
        assertEquals(employee.getId(), reportedExecution.getEmployee().getId(), 0);
    }

    @Test
    void getMachine() {
        Machine machine = new Machine("name");
        Employee employee = new Employee();
        ReportedExecution reportedExecution = new ReportedExecution(11.0, employee, machine, new Operation());
        assertEquals(machine.getId(), reportedExecution.getMachine().getId(), 0);
    }

    @Test
    void getDate() {
        Machine machine = new Machine("name");
        Employee employee = new Employee();
        ReportedExecution reportedExecution = new ReportedExecution(11.0, employee, machine, new Operation());
        assertEquals(new Date(), reportedExecution.getDate());
    }

    @Test
    void testToString() {
        Machine machine = new Machine("name");
        Employee employee = new Employee();
        ReportedExecution reportedExecution = new ReportedExecution(11.0, employee, machine, new Operation());
        assertEquals(machine + ", " + reportedExecution.getDate(), reportedExecution.toString());
    }
}