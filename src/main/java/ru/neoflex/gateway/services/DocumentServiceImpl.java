package ru.neoflex.gateway.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.gateway.feignclient.DealClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DealClient dealClient;

    @Override
    public void sendDocuments(Long applicationId) {
        log.info("Sending request to /deal/document/{}/send. Create documents request", applicationId);
        dealClient.sendDocuments(applicationId);
    }

    @Override
    public void signDocuments(Long applicationId) {
        log.info("Sending request to /deal/document/{}/sign. Sign documents request", applicationId);
        dealClient.signDocuments(applicationId);
    }

    @Override
    public void verifyCode(Long applicationId, Integer body) {
        log.info("Sending request to /deal/document/{}/code. Verify SES code request", applicationId);
        dealClient.verifyCode(applicationId, body);
    }
}
