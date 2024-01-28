package def;

import def.employee.Employee;
import def.employee.EmployeeService;
import def.machine.Machine;
import def.machine.MachineService;
import def.operation.Operation;
import def.reportedExecution.ReportedExecution;
import def.reportedExecution.ReportedExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MachineService machineService;
    @Autowired
    private ReportedExecutionService reportedExecutionService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reportedExecutions", reportedExecutionService.getAll());
        return "index";
    }

    @GetMapping("/employees")
    public String employees(@RequestParam(value = "fromIndex", required = false) Boolean fromIndex,
                            Model model) {
        if (fromIndex == null || !fromIndex) {
            return "redirect:";
        }
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }

    @GetMapping("/machines")
    public String machines(@RequestParam(value = "employee", required = false) Long employeeId,
                           Model model) {
        if (employeeId == null) {
            return "redirect:";
        }
        model.addAttribute("employee", employeeId);
        model.addAttribute("machines", machineService.getAll());
        return "machines";
    }

    @GetMapping("/quantity")
    public String quantity(@RequestParam(value = "machine", required = false) Long machineId,
                           @RequestParam(value = "employee", required = false) Long employeeId,
                           Model model) {
        if (machineId == null) {
            return "redirect:";
        }
        model.addAttribute("employee", employeeId);
        model.addAttribute("machine", machineId);
        return "quantityNotification";
    }

    @PostMapping("/quantity")
    public String postQuantity(@RequestParam(value = "machine", required = false) Long machineId,
                               @RequestParam(value = "employee", required = false) Long employeeId,
                               @RequestParam(value = "quantity", required = false) Double quantity) {

        Employee employee = employeeService.getById(employeeId);
        Machine machine = machineService.getById(machineId);
        reportedExecutionService.save(new ReportedExecution(quantity, employee, machine,new Operation()));
        return "redirect:";
    }

    @GetMapping("/reportedExecution")
    public String reportedExecution(@RequestParam(value = "re", required = false) Long reportedExecutionId,
                                    Model model) {
        ReportedExecution reportedExecution = reportedExecutionService.getById(reportedExecutionId);
        model.addAttribute("reportedExecution", reportedExecution);
        return "reportedExecution";
    }

}
