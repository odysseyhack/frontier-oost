package nl.frontieroost.darkEnergy.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import nl.frontieroost.darkEnergy.model.MgvoObject;

/**
 * DAO basic CRUD operations available
 *
 * @author Wely
 */
@Service
public interface MgvoRepository extends CrudRepository<MgvoObject, Integer> {

    Optional<MgvoObject> findByTokenId(long tokenId);
}
