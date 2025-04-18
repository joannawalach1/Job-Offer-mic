package pl.mic.joboffer;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JobOfferImporterRepository extends CassandraRepository<JobOffer, UUID> {
}
