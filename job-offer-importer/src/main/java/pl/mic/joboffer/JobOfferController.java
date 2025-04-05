package pl.mic.joboffer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mic.joboffer.dto.JobOfferDto;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JobOfferController {

    private final JobOfferService jobOfferService;

    @GetMapping("/fetch")
    public List<JobOfferDto> fetchOffers() {
       return jobOfferService.fetchAndSaveJobOffers();
    }

}
