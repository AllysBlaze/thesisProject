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

    @Column(name = "employee_work_time")
    private Long employeeWorkTime = 0L;

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

    public Long getEmployeeWorkTime() {
        return employeeWorkTime;
    }

    public void setEmployeeWorkTime(Long employeeWorkTime) {
        this.employeeWorkTime = employeeWorkTime;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }
}
