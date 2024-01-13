package htwberlin.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Ein REST-Controller für Stellenangebote mit CRUD-Operationen.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StellenangebotController {
    @Autowired
    StellenangebotService service;

    Logger logger = LoggerFactory.getLogger(StellenangebotController.class);

    /**
     * Erstellt ein neues Stellenangebot.
     *
     * @param stellenangebot Das zu erstellende Stellenangebot
     * @return Das erstellte Stellenangebot
     */
    @CrossOrigin
    @PostMapping("/stellenangebote")
    public Stellenangebot createStellenangebot(@RequestBody Stellenangebot stellenangebot) {
        return service.save(stellenangebot);
    }

    /**
     * Ruft ein bestimmtes Stellenangebot anhand der ID ab.
     *
     * @param id Die ID des abzurufenden Stellenangebots
     * @return Das abgerufene Stellenangebot
     */
    @CrossOrigin
    @GetMapping("/stellenangebote/{id}")
    public Stellenangebot getStellenangebot(@PathVariable String id) {
        logger.info("GET request on route stellenangebote with {}", id);
        Long stellenangebotId = Long.parseLong(id);
        return service.get(stellenangebotId);
    }

    /**
     * Ruft alle Stellenangebote ab.
     *
     * @return Eine Liste aller Stellenangebote
     */
    @CrossOrigin
    @GetMapping("/stellenangebote")
    public List<Stellenangebot> getAllStellenangebot() {
        return service.getAll();
    }

    /**
     * Aktualisiert ein bestimmtes Stellenangebot anhand der ID.
     *
     * @param id Die ID des zu aktualisierenden Stellenangebots
     * @param updatedStellenangebot Das aktualisierte Stellenangebot
     * @return Das aktualisierte Stellenangebot
     */
    @CrossOrigin
    @PutMapping("/stellenangebote/{id}")
    public ResponseEntity<Stellenangebot> updateStellenangebot(@PathVariable String id, @RequestBody Stellenangebot updatedStellenangebot) {
        Long stellenangebotId = Long.parseLong(id);
        Stellenangebot existingStellenangebot = service.get(stellenangebotId);
        if (existingStellenangebot != null) {

            existingStellenangebot.setJobTitle(updatedStellenangebot.getJobTitle());
            existingStellenangebot.setCompany(updatedStellenangebot.getCompany());
            existingStellenangebot.setLocation(updatedStellenangebot.getLocation());
            existingStellenangebot.setDescription(updatedStellenangebot.getDescription());
            existingStellenangebot.setDeadline(updatedStellenangebot.getDeadline());
            existingStellenangebot.setStartDate(updatedStellenangebot.getStartDate());

            Stellenangebot updated = service.save(existingStellenangebot);

            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Löscht ein bestimmtes Stellenangebot anhand der ID.
     *
     * @param id Die ID des zu löschenden Stellenangebots
     * @return Die HTTP-Response für die Löschoperation
     */
    @CrossOrigin
    @DeleteMapping("/stellenangebote/{id}")
    public ResponseEntity<Void> deleteStellenangebot(@PathVariable String id) {
        Long stellenangebotId = Long.parseLong(id);
        Stellenangebot existingStellenangebot = service.get(stellenangebotId);
        if (existingStellenangebot != null) {
            service.delete(stellenangebotId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
