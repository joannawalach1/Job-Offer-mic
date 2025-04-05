package pl.mic.joboffer;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class JobOfferService {

    private final JobOfferImporterRepository jobOfferImporterRepository;
    private final JobOfferFetcher jobOfferFetcher;

    public Flux<? extends JobOffer> fetchAndSaveJobOffers() {
        return jobOfferFetcher.fetchJobOffers()
                .collectList()
                .flatMapMany(list -> (Publisher<? extends JobOffer>) jobOfferImporterRepository.saveAll(list));
    }
}