package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Service für die Geschäftslogik von Stellenangeboten.
 */
@Service
public class StellenangebotService {


    @Autowired
    StellenangebotRepository repo;

    /**
     * Speichert ein Stellenangebot.
     *
     * @param stellenangebot Das zu speichernde Stellenangebot
     * @return Das gespeicherte Stellenangebot
     */
    public Stellenangebot save(Stellenangebot stellenangebot) {
        return repo.save(stellenangebot);
    }

    /**
     * Ruft ein Stellenangebot anhand der ID ab.
     *
     * @param id Die ID des abzurufenden Stellenangebots
     * @return Das abgerufene Stellenangebot
     */
    public Stellenangebot get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    /**
     * Ruft alle Stellenangebote ab.
     *
     * @return Eine Liste aller Stellenangebote
     */
    public List<Stellenangebot> getAll() {
        Iterable<Stellenangebot> iterator = repo.findAll();
        List<Stellenangebot> stellenangebote = new ArrayList<>();
        for (Stellenangebot stellenangebot : iterator) {
            stellenangebote.add(stellenangebot);
        }
        return stellenangebote;
    }

    /**
     * Löscht ein Stellenangebot anhand der ID
     *
     * @param id Die ID des zu löschenden Stellenangebots
     */
    public void delete(Long id) {
        repo.deleteById(id);
    }
}