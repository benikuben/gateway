package ru.neoflex.gateway.services;

import ru.neoflex.openapi.dtos.FinishRegistrationRequest;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.LoanOffer;

import java.util.List;

public interface ApplicationService {
    void applyOffer(LoanOffer loanOffer);

    List<LoanOffer> createApplication(LoanApplicationRequest loanApplicationRequest);

    void finishRegistration(Long applicationId, FinishRegistrationRequest finishRegistrationRequest);
}
