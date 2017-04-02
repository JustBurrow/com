package com.borderline.web.converter;

import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service class SiteDtoConverterImpl extends AbstractDtoConverter implements SiteDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(SiteDtoConverter.class);

  @Override
  public SiteDto convert(Site site) {
    if (log.isDebugEnabled()) {
      log.debug(format("site=%s", site));
    }

    SiteDto dto = initialize(site, new SiteDto());
    dto.setUrl(site.getUrl());

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%", dto));
    }
    return dto;
  }

  @Override
  public List<SiteDto> convert(List<Site> sites) {
    if (log.isDebugEnabled()) {
      log.debug(format("sites=%s", sites));
    }

    List<SiteDto> list = sites.stream().map(site -> convert(site)).collect(Collectors.toList());

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }
}
