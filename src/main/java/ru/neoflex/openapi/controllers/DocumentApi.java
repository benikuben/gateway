/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.neoflex.openapi.controllers;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-03T20:08:46.762957400+03:00[Europe/Moscow]")
@Validated
@Tag(name = "document", description = "the document API")
public interface DocumentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /document/{applicationId} : Create document request
     *
     * @param applicationId Id of application (required)
     * @return Successfully sent (status code 200)
     */
    @Operation(
        operationId = "sendDocuments",
        summary = "Create document request",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully sent")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/document/{applicationId}"
    )
    default ResponseEntity<Void> _sendDocuments(
        @Parameter(name = "applicationId", description = "Id of application", required = true, in = ParameterIn.PATH) @PathVariable("applicationId") Long applicationId
    ) {
        return sendDocuments(applicationId);
    }

    // Override this method
    default  ResponseEntity<Void> sendDocuments(Long applicationId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /document/{applicationId}/sign : Sign documents request
     *
     * @param applicationId Id of application (required)
     * @return Successfully sent (status code 200)
     */
    @Operation(
        operationId = "signDocuments",
        summary = "Sign documents request",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully sent")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/document/{applicationId}/sign"
    )
    default ResponseEntity<Void> _signDocuments(
        @Parameter(name = "applicationId", description = "Id of application", required = true, in = ParameterIn.PATH) @PathVariable("applicationId") Long applicationId
    ) {
        return signDocuments(applicationId);
    }

    // Override this method
    default  ResponseEntity<Void> signDocuments(Long applicationId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /document/{applicationId}/sign/code : Verify SES code request
     *
     * @param applicationId Id of application (required)
     * @param body  (required)
     * @return Documents signed (status code 200)
     */
    @Operation(
        operationId = "verifyCode",
        summary = "Verify SES code request",
        responses = {
            @ApiResponse(responseCode = "200", description = "Documents signed")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/document/{applicationId}/sign/code",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _verifyCode(
        @Parameter(name = "applicationId", description = "Id of application", required = true, in = ParameterIn.PATH) @PathVariable("applicationId") Long applicationId,
        @Parameter(name = "body", description = "", required = true) @Valid @RequestBody Integer body
    ) {
        return verifyCode(applicationId, body);
    }

    // Override this method
    default  ResponseEntity<Void> verifyCode(Long applicationId, Integer body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
