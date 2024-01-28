package def.reportedExecution;

import def.employee.Employee;
import def.machine.Machine;
import def.operation.Operation;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reported_execution")
public class ReportedExecution {
    @Id
    @GeneratedValue
    @Column(name = "reported_execution_id")
    private Long id;

    @Column(name = "reported_execution_quantity")
    private Double quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operations_id")
    private Operation operation;

    @Column(name = "reported_execution_date")
    private Date date;

    public ReportedExecution(Double quantity, Employee employee, Machine machine,Operation operation) {
        this.quantity = quantity;
        this.employee = employee;
        this.machine = machine;
        this.date = new Date();
        this.operation = operation;
    }

    public ReportedExecution() {
    }

    public Long getId() {
        return id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Machine getMachine() {
        return machine;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return machine + ", " + date;
    }
}
