package pl.mic.joboffer;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.mic.joboffer.dto.JobOfferDto;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class JobOfferFetcher {

    private final WebClient webClient;

    public JobOfferFetcher(WebClient webClient) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.pracuj.pl")
                .build();
    }

    public Flux<JobOffer> fetchJobOffers() {
        return webClient.get()
                .uri("/offers")
                .retrieve()
                .bodyToFlux(JobOfferDto.class)
                .map(dto -> new JobOffer(
                        UUID.randomUUID(),
                        dto.company(),
                        dto.title(),
                        dto.salary(),
                        dto.url()
                ));
    }
}
