package htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StellenangebotTest {

    @Test
    @DisplayName("should return a formatted string representation of Stellenangebot")
    void testToString() {
        Long id = 1L;
        String jobTitle = "Software Engineer";
        String company = "Tech Innovations GmbH";
        String location = "Berlin, Deutschland";
        String description = "Wir suchen einen erfahrenen Softwareentwickler, der unser agiles Team bei der Entwicklung von innovativen Lösungen unterstützt.";
        String deadline = "2024-01-10";
        String startDate = "2024-02-01";

        Stellenangebot stellenangebot = new Stellenangebot(jobTitle, company, location, description, deadline, startDate);
        stellenangebot.setId(id);

        String expected = "Stellenangebot{id=1, jobTitle='Software Engineer', company='Tech Innovations GmbH', location='Berlin, Deutschland', description='Wir suchen einen erfahrenen Softwareentwickler, der unser agiles Team bei der Entwicklung von innovativen Lösungen unterstützt.', deadline='2024-01-10', startDate='2024-02-01'}";

        String actual = stellenangebot.toString();

        assertEquals(expected, actual);
    }
}

