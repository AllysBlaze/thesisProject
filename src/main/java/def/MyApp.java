package def;


import def.employee.Employee;
import def.employee.EmployeeService;
import def.machine.Machine;
import def.machine.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MachineService machineService;

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    public void run(String args[]) throws Exception {
        employeeService.saveEmployee(new Employee("k", "p"));
        employeeService.saveEmployee(new Employee("m", "c"));

        machineService.saveMachine(new Machine("cnc01"));
        machineService.saveMachine(new Machine("cnc02"));

    }
}