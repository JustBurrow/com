package com.borderline.web;

import com.borderline.web.converter.LayoutDtoConverter;
import com.borderline.web.dto.LayoutDto;
import com.domain.web.Layout;
import com.domain.web.Site;
import com.service.web.LayoutService;
import com.service.web.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Service class LayoutBorderlineImpl implements LayoutBorderline {
  private static final Logger log = LoggerFactory.getLogger(LayoutBorderline.class);

  @Autowired
  private LayoutService      layoutService;
  @Autowired
  private LayoutDtoConverter layoutDtoConverter;
  @Autowired
  private SiteService        siteService;

  @Override
  public List<LayoutDto> list(int siteId) {
    if (log.isDebugEnabled()) {
      log.debug(format("siteId=%d", siteId));
    }

    Site            site    = this.siteService.read(siteId);
    List<Layout>    list    = this.layoutService.list(site);
    List<LayoutDto> dtoList = this.layoutDtoConverter.convert(list);

    if (log.isDebugEnabled()) {
      log.debug(format("dtoList=%s", dtoList));
    }
    return dtoList;
  }

  @Override
  public LayoutDto read(int id) {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d", id));
    }

    Layout    layout =layoutService.read(id);
    LayoutDto dto = layoutDtoConverter.convert(layout);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
