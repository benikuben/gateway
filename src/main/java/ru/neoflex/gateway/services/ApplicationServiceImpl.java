package ru.neoflex.gateway.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.gateway.feignclient.ApplicationClient;
import ru.neoflex.gateway.feignclient.DealClient;
import ru.neoflex.openapi.dtos.FinishRegistrationRequest;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.LoanOffer;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationClient applicationClient;
    private final DealClient dealClient;

    @Override
    public void applyOffer(LoanOffer loanOffer) {
        log.info("Sending request to /application/offer. Offer to be applied - {}", loanOffer);
        applicationClient.applyOffer(loanOffer);
    }

    @Override
    public List<LoanOffer> createApplication(LoanApplicationRequest loanApplicationRequest) {
        log.info("Sending request to /application. LoanApplicationRequest - {}", loanApplicationRequest);
        List<LoanOffer> offers = applicationClient.createApplication(loanApplicationRequest).getBody();
        log.info("Generated offers - {}", offers);
        return offers;
    }

    @Override
    public void finishRegistration(Long applicationId, FinishRegistrationRequest finishRegistrationRequest) {
        log.info("Sending request to /deal/calculate/{}. FinishRegistrationRequest - {}", applicationId, finishRegistrationRequest);
        dealClient.finishRegistration(applicationId, finishRegistrationRequest);
    }
}
