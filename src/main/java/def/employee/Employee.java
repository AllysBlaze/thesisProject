package def.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_surname")
    private String surname;

    @Column(name = "employee_produced_quantity")
    private Double employeeProducedQuantity = 0.0;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getEmployeeProducedQuantity() {
        return employeeProducedQuantity;
    }

    public void setEmployeeProducedQuantity(Double employeeProducedQuantity) {
        this.employeeProducedQuantity = this.employeeProducedQuantity + employeeProducedQuantity;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }
}
