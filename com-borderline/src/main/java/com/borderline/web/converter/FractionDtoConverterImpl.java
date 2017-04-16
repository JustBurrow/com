package com.borderline.web.converter;

import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.borderline.web.dto.FractionDto;
import com.domain.web.Fraction;

/**
 * @author justburrow
 * @since 2017. 4. 12.
 */
@Component
class FractionDtoConverterImpl extends AbstractDtoConverter implements FractionDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(FractionDtoConverter.class);

  @Override
  public FractionDto convert(Fraction fraction) {
    if (log.isDebugEnabled()) {
      log.debug(format("fraction=%s", fraction));
    }

    FractionDto dto = this.initialize(fraction, new FractionDto());
    dto.setName(fraction.getName());
    dto.setFractionTemplate(fraction.getFractionTemplate());

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
