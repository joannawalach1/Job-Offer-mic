package pl.mic.joboffer;

import org.springframework.data.cassandra.core.mapping.Table;

@Table("job_offer")
public record JobOffer(java.util.UUID id, String company, String title, String salary, String url) {
}
