package com.borderline.web.converter;

import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service class SiteDtoConverterImpl extends AbstractDtoConverter implements SiteDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(SiteDtoConverter.class);

  @Autowired
  private PageDtoConverter pageDtoConverter;

  @Override
  public SiteDto convert(Site site) {
    return convert(site, new PagingDtoConvertContext(0, Site.DEFAULT_PAGE_SIZE));
  }

  @Override
  public SiteDto convert(Site site, PagingDtoConvertContext context) {
    if (log.isDebugEnabled()) {
      log.debug(format("site=%s", site));
    }

    SiteDto dto = initialize(site, new SiteDto());
    dto.setUrl(site.getUrl());
    dto.setPages(convertPartialList(site.getPages(context.getPage(), context.getSize()), this.pageDtoConverter));

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
