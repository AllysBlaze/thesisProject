package def.reportedExecution;

import def.employee.Employee;
import def.machine.Machine;
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
    private Float quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @Column(name = "reported_execution_date")
    private Date date;

    public ReportedExecution(Float quantity, Employee employee, Machine machine) {
        this.quantity = quantity;
        this.employee = employee;
        this.machine = machine;
        this.date = new Date();
    }

    public ReportedExecution() {
    }

    public Long getId() {
        return id;
    }

    public Float getQuantity() {
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
