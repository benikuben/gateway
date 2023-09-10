package ru.neoflex.gateway.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.gateway.services.DocumentService;
import ru.neoflex.openapi.controllers.DocumentApi;

@RestController
@RequiredArgsConstructor
public class DocumentController implements DocumentApi {
    private final DocumentService documentService;

    @Override
    public ResponseEntity<Void> sendDocuments(Long applicationId) {
        documentService.sendDocuments(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> signDocuments(Long applicationId) {
        documentService.signDocuments(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> verifyCode(Long applicationId, Integer body) {
        documentService.verifyCode(applicationId, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
