package def.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).get();
    }

    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
