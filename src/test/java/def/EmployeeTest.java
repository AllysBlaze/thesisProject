package def;

import def.employee.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void getNameAndSurname() {
        Employee employee = new Employee("name", "surname");
        assertEquals("name", employee.getName());
        assertEquals("surname", employee.getSurname());
    }

    @Test
    void testToString() {
        Employee employee = new Employee("name", "surname");
        assertEquals(employee.getId() + ". name surname", employee.toString());
    }
}