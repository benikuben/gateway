package ru.neoflex.gateway.services;

public interface DocumentService {
    void sendDocuments(Long applicationId);

    void signDocuments(Long applicationId);

    void verifyCode(Long applicationId, Integer body);
}
