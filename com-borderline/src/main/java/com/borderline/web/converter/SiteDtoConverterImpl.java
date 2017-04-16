package com.borderline.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service
class SiteDtoConverterImpl extends AbstractDtoConverter implements SiteDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(SiteDtoConverter.class);

  @Override
  public SiteDto convert(Site site) {
    if (log.isDebugEnabled()) {
      log.debug(String.format("site=%s", site));
    }

    SiteDto dto = this.initialize(site, new SiteDto());
    dto.setUrl(site.getUrl());

    if (log.isDebugEnabled()) {
      log.debug(String.format("dto=%s", dto));
    }
    return dto;
  }
}
