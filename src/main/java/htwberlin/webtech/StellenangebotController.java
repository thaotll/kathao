package htwberlin.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StellenangebotController {
    @Autowired
    StellenangebotService service;

    Logger logger = LoggerFactory.getLogger(StellenangebotController.class);

    @CrossOrigin
    @PostMapping("/stellenangebote")
    public Stellenangebot createStellenangebot(@RequestBody Stellenangebot stellenangebot) {
        return service.save(stellenangebot);
    }

    @CrossOrigin
    @GetMapping("/stellenangebote/{id}")
    public Stellenangebot getStellenangebot(@PathVariable String id) {
        logger.info("GET request on route stellenangebote with {}", id);
        Long stellenangebotId = Long.parseLong(id);
        return service.get(stellenangebotId);
    }

    @CrossOrigin
    @GetMapping("/stellenangebote")
    public List<Stellenangebot> getAllStellenangebot() {
        return service.getAll();
    }

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
