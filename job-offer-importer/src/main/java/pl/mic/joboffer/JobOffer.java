package pl.mic.joboffer;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("job_offer")
public record JobOffer(
        @PrimaryKey
        UUID id,
        String company,
        String title,
        String salary,
        String url) {
}
