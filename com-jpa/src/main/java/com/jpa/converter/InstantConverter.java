package com.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Long> {
  @Override
  public Long convertToDatabaseColumn(Instant instant) {
    return null == instant ? null : instant.toEpochMilli();
  }

  @Override
  public Instant convertToEntityAttribute(Long utcMillis) {
    return null == utcMillis ? null : Instant.ofEpochMilli(utcMillis);
  }
}
