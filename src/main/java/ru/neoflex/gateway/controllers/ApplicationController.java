package ru.neoflex.gateway.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.gateway.services.ApplicationService;
import ru.neoflex.openapi.controllers.ApplicationApi;
import ru.neoflex.openapi.dtos.FinishRegistrationRequest;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.LoanOffer;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplicationController implements ApplicationApi {
    private final ApplicationService applicationService;

    @Override
    public ResponseEntity<Void> applyOffer(LoanOffer loanOffer) {
        applicationService.applyOffer(loanOffer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LoanOffer>> createApplication(LoanApplicationRequest loanApplicationRequest) {
        return new ResponseEntity<>(applicationService.createApplication(loanApplicationRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> finishRegistration(Long applicationId, FinishRegistrationRequest finishRegistrationRequest) {
        applicationService.finishRegistration(applicationId, finishRegistrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
