package htwberlin.webtech;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Ein Repository für die Entität "Stellenangebot".
 */
@Repository
public interface StellenangebotRepository extends CrudRepository<Stellenangebot, Long>{
}