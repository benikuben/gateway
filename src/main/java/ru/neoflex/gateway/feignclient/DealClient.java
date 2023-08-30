package ru.neoflex.gateway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.openapi.dtos.FinishRegistrationRequest;

@FeignClient(name = "deal", url = "${deal.url}", path = "/deal")
public interface DealClient {
    @PutMapping("/calculate/{applicationId}")
    ResponseEntity<Void> finishRegistration(@PathVariable Long applicationId, @RequestBody FinishRegistrationRequest finishRegistrationRequestDTO);

    @PostMapping("/document/{applicationId}/send")
    ResponseEntity<Void> sendDocuments(@PathVariable Long applicationId);

    @PostMapping("/document/{applicationId}/sign")
    ResponseEntity<Void> signDocuments(@PathVariable Long applicationId);

    @PostMapping("/document/{applicationId}/code")
    ResponseEntity<Void> verifyCode(@PathVariable Long applicationId, @RequestBody Integer sesCode);
}
