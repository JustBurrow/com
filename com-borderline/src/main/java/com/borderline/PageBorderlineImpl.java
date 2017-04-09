package com.borderline;

import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.cmd.ReadPageCmd;
import com.borderline.web.converter.PageDtoConverter;
import com.borderline.web.dto.PageDto;
import com.domain.web.Layout;
import com.domain.web.Page;
import com.domain.web.Site;
import com.service.web.LayoutService;
import com.service.web.PageService;
import com.service.web.SiteService;
import com.service.web.params.CreatePageParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Service class PageBorderlineImpl implements PageBorderline {
  private static final Logger log = LoggerFactory.getLogger(PageBorderline.class);

  @Autowired
  private PageService      pageService;
  @Autowired
  private PageDtoConverter pageDtoConverter;
  @Autowired
  private SiteService      siteService;
  @Autowired
  private LayoutService    layoutService;

  @Override
  public PageDto create(CreatePageCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    Site             site   = this.siteService.read(cmd.getSite());
    Layout           layout = this.layoutService.read(cmd.getLayout());
    CreatePageParams params = new CreatePageParams(site, cmd.getPath(), cmd.getTitle(), layout, cmd.getDescription());
    Page             page   = this.pageService.create(params);
    PageDto          dto    = this.pageDtoConverter.convert(page);


    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }

  @Override
  public PageDto read(ReadPageCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    Page    page = this.pageService.read(cmd.getPage());
    if (cmd.getSite() != page.getSite().getId()){
      return null;
    }

    PageDto dto  = this.pageDtoConverter.convert(page);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
