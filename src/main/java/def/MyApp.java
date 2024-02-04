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
        employeeService.save(new Employee("k", "p"));
        employeeService.save(new Employee("m", "c"));

        Machine cnc01 = new Machine("cnc01");
        machineService.save(cnc01);
        Machine cnc02 = new Machine("cnc02");
        machineService.save(cnc02);
//
//        operationService.save(new Operation("op1",cnc02,11d));
//        operationService.save(new Operation("op2",cnc02,15d));
//        operationService.save(new Operation("op3",cnc01,22d));

    }
}