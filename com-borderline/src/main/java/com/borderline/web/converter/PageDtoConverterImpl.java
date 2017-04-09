package com.borderline.web.converter;

import com.borderline.web.dto.PageDto;
import com.domain.web.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Component class PageDtoConverterImpl extends AbstractDtoConverter implements PageDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(PageDtoConverter.class);

  @Override
  public PageDto convert(Page page) {
    return convert(page, null);
  }

  @Override
  public PageDto convert(Page page, DtoConvertContext context) {
    if (log.isDebugEnabled()) {
      log.debug(format("page=%s", page));
    }

    PageDto dto = initialize(page, new PageDto());
    dto.setSite(page.getSite().getUrl());
    dto.setPath(page.getPath());
    dto.setTitle(page.getTitle());

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
