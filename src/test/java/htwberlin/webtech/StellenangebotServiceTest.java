package htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@SpringBootTest
class StellenangebotServiceTest {

    @MockBean
    private StellenangebotRepository repo;

    @Autowired
    private StellenangebotService stellenangebotService; // StellenangebotService automatisch injizieren

    @Test
    @DisplayName("should save a Stellenangebot")
    void testSaveStellenangebot() {
        Stellenangebot stellenangebot = new Stellenangebot("Software Engineer", "Tech Innovations GmbH", "Berlin, Deutschland", "Wir suchen einen erfahrenen Softwareentwickler, der unser agiles Team bei der Entwicklung von innovativen Lösungen unterstützt.", "2024-01-10", "2024-02-01");

        doReturn(stellenangebot).when(repo).save(any(Stellenangebot.class));

        Stellenangebot savedStellenangebot = stellenangebotService.save(stellenangebot);

        assertEquals("Software Engineer", savedStellenangebot.getJobTitle());
        assertEquals("Tech Innovations GmbH", savedStellenangebot.getCompany());
        assertEquals("Berlin, Deutschland", savedStellenangebot.getLocation());
    }

    @Test
    @DisplayName("should find a Stellenangebot by its id")
    void testGet() {
        Stellenangebot stellenangebot1 = new Stellenangebot("Software Engineer", "Tech Innovations GmbH", "Berlin, Deutschland", "Wir suchen einen erfahrenen Softwareentwickler, der unser agiles Team bei der Entwicklung von innovativen Lösungen unterstützt.", "2024-01-10", "2024-02-01");
        Stellenangebot stellenangebot2 = new Stellenangebot("Marketing Manager", "MarketBoost AG", "München, Deutschland", "Wir suchen einen Marketing Manager mit nachgewiesener Erfahrung im Aufbau von Marken und der Entwicklung erfolgreicher Marketingstrategien.Kommunikationsgeschick und Kreativität sind gefragt!", "2024-01-15", "2024-02-15");

        when(repo.findById(1L)).thenReturn(Optional.of(stellenangebot1));
        when(repo.findById(2L)).thenReturn(Optional.of(stellenangebot2));

        Stellenangebot actual = stellenangebotService.get(1L);

        assertEquals("Software Engineer", actual.getJobTitle());
        assertEquals("Tech Innovations GmbH", actual.getCompany());
        assertEquals("Berlin, Deutschland", actual.getLocation());
    }
}