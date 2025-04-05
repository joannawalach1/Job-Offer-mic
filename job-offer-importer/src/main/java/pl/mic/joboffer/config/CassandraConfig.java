package pl.mic.joboffer.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.ReactiveSession;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.InetSocketAddress;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig {

    @Bean
    public CqlSession cassandraSession() {
        return CqlSession.builder()
                .addContactPoint(InetSocketAddress.createUnresolved("127.0.0.1", 9042))
                .withLocalDatacenter("datacenter1")
                .build();
    }

    @Bean
    public ReactiveCassandraTemplate reactiveCassandraTemplate(ReactiveSession session) {
        return new ReactiveCassandraTemplate(session);
    }
}