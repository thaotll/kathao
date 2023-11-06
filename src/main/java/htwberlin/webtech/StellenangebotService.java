package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StellenangebotService {


    @Autowired
    StellenangebotRepository repo;

    public Stellenangebot save(Stellenangebot stellenangebot) {
        return repo.save(stellenangebot);
    }

    public Stellenangebot get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Stellenangebot> getAll() {
        Iterable<Stellenangebot> iterator = repo.findAll();
        List<Stellenangebot> stellenangebote = new ArrayList<>();
        for (Stellenangebot stellenangebot : iterator) {
            stellenangebote.add(stellenangebot);
        }
        return stellenangebote;
    }
}