

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @BeforeEach
    public void setUp() {
        Person person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(new Calendar.Builder().setDate(1942, Calendar.JANUARY, 8).build().getTime());
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", Person.fullName("Paul", "McCartney"));
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400, Person.calculateYearlySalary(1200));
    }

    @Test
    public void person_is_MEI() {
        float salary = 1200;
        Person person = new Person();
        person.setBirthDate(new Calendar.Builder().setDate(1942, Calendar.JANUARY, 8).build().getTime());
        person.setPublicServer(false);
        person.setPensioner(false);
        person.setAnotherCompanyOwner(false);

        assertTrue(Person.isMEI(salary, person.isAnotherCompanyOwner(), person.isPensioner(), person.isPublicServer(), person.getBirthDate()));
    }

    @Test
    public void person_is_not_MEI() {
        float salary = 50000;
        Date birthDate = new Calendar.Builder().setDate(1942, Calendar.JANUARY, 8).build().getTime();
        Person person = new Person();
        person.setPublicServer(true);
        person.setPensioner(true);
        person.setAnotherCompanyOwner(true);

        assertFalse(Person.isMEI(salary, person.isAnotherCompanyOwner(), person.isPensioner(), person.isPublicServer(), birthDate));
    }
}
