package htwberlin.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StellenangebotController {
    @Autowired
    StellenangebotService service;

    Logger logger = LoggerFactory.getLogger(StellenangebotController.class);

    @PostMapping("/stellenangebote")
    public Stellenangebot createStellenangebot(@RequestBody Stellenangebot stellenangebot) {
        return service.save(stellenangebot);
    }

    @GetMapping("/stellenangebote/{id}")
    public Stellenangebot getStellenangebot(@PathVariable String id) {
        logger.info("GET request on route stellenangebote with {}", id);
        Long stellenangebotId = Long.parseLong(id);
        return service.get(stellenangebotId);
    }

    @GetMapping("/stellenangebote")
    public List<Stellenangebot> getAllStellenangebot() {
        return service.getAll();
    }
}
