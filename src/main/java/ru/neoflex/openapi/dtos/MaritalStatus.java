package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Martial status
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-30T15:07:27.412559600+03:00[Europe/Moscow]")
public enum MaritalStatus {
  
  MARRIED("MARRIED"),
  
  DIVORCED("DIVORCED"),
  
  SINGLE("SINGLE"),
  
  WIDOW_WIDOWER("WIDOW_WIDOWER");

  private String value;

  MaritalStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MaritalStatus fromValue(String value) {
    for (MaritalStatus b : MaritalStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

