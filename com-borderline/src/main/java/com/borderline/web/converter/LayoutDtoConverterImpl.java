package com.borderline.web.converter;

import com.borderline.web.dto.FractionDto;
import com.borderline.web.dto.LayoutDto;
import com.domain.web.Layout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Component class LayoutDtoConverterImpl extends AbstractDtoConverter implements LayoutDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(LayoutDtoConverter.class);

  @Autowired
  private FractionDtoConverter fractionDtoConverter;

  @Override
  public LayoutDto convert(Layout layout) {
    return convert(layout, null);
  }

  @Override
  public LayoutDto convert(Layout layout, PagingDtoConvertContext context) {
    if (log.isDebugEnabled()) {
      log.debug(format("source=%s", layout));
    }

    LayoutDto dto = initialize(layout, new LayoutDto());
    dto.setLayoutTemplate(layout.getLayoutTemplate());

    Map<String, FractionDto> fractions = layout
        .getFractions()
        .entrySet()
        .stream()
        .collect(toMap(
            Entry::getKey,
            e -> this.fractionDtoConverter.convert(e.getValue()))
        );
    dto.setFractions(fractions);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
