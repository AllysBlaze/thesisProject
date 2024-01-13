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


    public Employee(String name, String surname) {
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

    @Override
    public String toString() {
        return id +". "+name+" "+surname;
    }
}
