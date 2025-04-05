package pl.mic.joboffer;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import pl.mic.joboffer.dto.JobOfferDto;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOfferService {

    private final JobOfferImporterRepository jobOfferImporterRepository;
    private final JobOfferFetcher jobOfferFetcher;

    public List<JobOfferDto> fetchAndSaveJobOffers() {
        return jobOfferFetcher.fetchJobOffers();
    }
}