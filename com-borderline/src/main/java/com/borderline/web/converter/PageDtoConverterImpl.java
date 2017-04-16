package com.borderline.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.borderline.web.dto.PageDto;
import com.domain.web.Page;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Component
class PageDtoConverterImpl extends AbstractDtoConverter implements PageDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(PageDtoConverter.class);

  @Autowired
  private LayoutDtoConverter   layoutDtoConverter;
  @Autowired
  private FractionDtoConverter fractionDtoConverter;

  @Override
  public PageDto convert(Page page) {
    if (log.isDebugEnabled()) {
      log.debug(String.format("page=%s", page));
    }

    if (null == page) {
      throw new NullPointerException("page");
    }

    PageDto dto = this.initialize(page, new PageDto());
    dto.setSite(page.getSite().getUrl());
    dto.setPath(page.getPath());
    dto.setTitle(page.getTitle());
    dto.setLayout(this.layoutDtoConverter.convert(page.getLayout()));

    page.getLayout().getFractions().forEach((name, fraction) -> {
      dto.putFraction(name, this.fractionDtoConverter.convert(fraction));
      // TODO content object & content collection
    });

    if (log.isDebugEnabled()) {
      log.debug(String.format("dto=%s", dto));
    }
    return dto;
  }
}
