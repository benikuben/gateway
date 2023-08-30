package ru.neoflex.gateway.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.neoflex.openapi.dtos.ErrorResponse;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErrorResponse> handleFeignException(FeignException e) throws JsonProcessingException {
        HttpStatus status = HttpStatus.valueOf(e.status());

        if (status.is4xxClientError()) {
            String message = e.contentUTF8();
            ObjectMapper mapper = new ObjectMapper();

            try {
                ObjectReader reader = mapper.readerForListOf(ErrorResponse.class);
                return reader.readValue(message);
            } catch (MismatchedInputException ex) {
                return List.of(mapper.readValue(message, ErrorResponse.class));
            }
        }
        return List.of(new ErrorResponse("Unexpected error"));
    }

    @ResponseBody
    @ExceptionHandler({InvalidFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidFormatException(InvalidFormatException e) {
        return new ErrorResponse(e.getValue() + " - невалидное значение");
    }
}
