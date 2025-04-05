package pl.mic.joboffer.jobOffer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class JobOfferImporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobOfferImporterApplication.class, args);
    }
}
