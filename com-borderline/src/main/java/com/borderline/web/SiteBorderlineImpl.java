package com.borderline.web;

import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.converter.SiteDtoConverter;
import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;
import com.service.web.SiteService;
import com.service.web.params.CreateSiteParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service class SiteBorderlineImpl implements SiteBorderline {
  private static final Logger log = LoggerFactory.getLogger(SiteBorderline.class);

  @Autowired
  private SiteService      siteService;
  @Autowired
  private SiteDtoConverter siteDtoConverter;

  @Override
  public SiteDto create(CreateSiteCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    CreateSiteParams params = new CreateSiteParams(cmd.getUrl(), cmd.getDescription());
    Site             site   = this.siteService.create(params);

    SiteDto dto = this.siteDtoConverter.convert(site);
    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }

  @Override
  public List<SiteDto> list() {
    List<Site>    sites = this.siteService.list();
    List<SiteDto> list  = this.siteDtoConverter.convert(sites);

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }
}
