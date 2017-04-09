package com.borderline.web.converter;

import com.borderline.web.dto.LayoutDto;
import com.domain.web.Layout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Component class LayoutDtoConverterImpl extends AbstractDtoConverter implements LayoutDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(LayoutDtoConverter.class);

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
    dto.setName(layout.getName());

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
