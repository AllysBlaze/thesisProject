package def;

import def.employee.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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