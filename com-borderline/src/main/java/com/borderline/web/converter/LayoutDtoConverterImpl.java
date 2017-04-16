package com.borderline.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.borderline.web.dto.LayoutDto;
import com.domain.web.Layout;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Component
class LayoutDtoConverterImpl extends AbstractDtoConverter implements LayoutDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(LayoutDtoConverter.class);

  @Override
  public LayoutDto convert(Layout layout) {
    if (log.isDebugEnabled()) {
      log.debug(String.format("source=%s", layout));
    }

    LayoutDto dto = this.initialize(layout, new LayoutDto());
    dto.setLayoutTemplate(layout.getLayoutTemplate());

    if (log.isDebugEnabled()) {
      log.debug(String.format("dto=%s", dto));
    }
    return dto;
  }
}
