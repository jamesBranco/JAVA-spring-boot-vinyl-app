package edu.cscc.lab12.repo;

import edu.cscc.lab12.model.VinylRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinylRecordRepository extends CrudRepository<VinylRecord, Long> {
}
