package pl.mic.joboffer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JobOfferController {

    private final JobOfferService jobOfferService;

    @GetMapping("/fetch")
    public Flux<? extends JobOffer> fetchOffers() {
       return jobOfferService.fetchAndSaveJobOffers();
    }

}
