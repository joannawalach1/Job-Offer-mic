package pl.mic.joboffer;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.mic.joboffer.dto.JobOfferDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class JobOfferFetcher {

    private final WebClient webClient;

    public JobOfferFetcher(WebClient webClient) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.pracuj.pl")
                .build();
    }

    public List<JobOfferDto> fetchJobOffers() {
        return webClient.get()
                .uri("/offers")
                .retrieve()
                .bodyToFlux(JobOfferDto.class)
                .collectList()
                .block();
    }
}
