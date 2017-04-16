package com.borderline;

import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.cmd.ReadPageCmd;
import com.borderline.web.cmd.UpdatePageCmd;
import com.borderline.web.converter.FractionDtoConverter;
import com.borderline.web.converter.PageDtoConverter;
import com.borderline.web.converter.SiteDtoConverter;
import com.borderline.web.dto.DtoMap;
import com.borderline.web.dto.FractionDto;
import com.borderline.web.dto.PageDto;
import com.domain.web.Layout;
import com.domain.web.Page;
import com.domain.web.Site;
import com.service.web.LayoutService;
import com.service.web.PageService;
import com.service.web.SiteService;
import com.service.web.params.CreatePageParams;
import com.service.web.params.UpdatePageParams;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Service
class PageBorderlineImpl implements PageBorderline {
  private static final Logger log = LoggerFactory.getLogger(PageBorderline.class);

  @Autowired
  private PageService          pageService;
  @Autowired
  private PageDtoConverter     pageDtoConverter;
  @Autowired
  private SiteService          siteService;
  @Autowired
  private LayoutService        layoutService;
  @Autowired
  private SiteDtoConverter     siteDtoConverter;
  @Autowired
  private FractionDtoConverter fractionDtoConverter;

  @Override
  public PageDto create(CreatePageCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    Site site = this.siteService.read(cmd.getSite());
    Layout layout = this.layoutService.read(cmd.getLayout());
    CreatePageParams params = new CreatePageParams(site, cmd.getPath(), cmd.getTitle(), layout, cmd.getDescription());
    Page page = this.pageService.create(params);
    PageDto dto = this.pageDtoConverter.convert(page);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }

  @Override
  public DtoMap read(ReadPageCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    DtoMap map = new DtoMap();

    Page page = this.pageService.read(cmd.getPage());
    if (cmd.getSite() != page.getSite().getId()) {
      return null;
    }

    map.put("site", this.siteDtoConverter.convert(page.getSite()));

    PageDto dto = this.pageDtoConverter.convert(page);
    map.put("page", dto);
    map.put("layouts", this.layoutService.list(page.getSite()));

    Map<String, FractionDto> fractions = page.getLayout().getFractions().entrySet().stream()
        .collect(toMap(Map.Entry::getKey, e -> this.fractionDtoConverter.convert(e.getValue())));
    map.put("fractions", fractions);

    if (log.isDebugEnabled()) {
      log.debug(format("map=%s", map));
    }
    return map;
  }

  @Override
  public PageDto read(URL url) {
    if (log.isDebugEnabled()) {
      log.debug(format("url=%s", url));
    }

    Site site = this.siteService.read(url);

    String path = url.getPath();
    path = path.replaceAll("^/", "");
    Page page = this.pageService.read(site, path);
    PageDto dto = this.pageDtoConverter.convert(page);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }

  @Override
  public PageDto update(UpdatePageCmd cmd) {
    if (log.isDebugEnabled()) {
      log.debug(format("cmd=%s", cmd));
    }

    Site site = this.siteService.read(cmd.getSite());
    Layout layout = this.layoutService.read(cmd.getLayout());

    UpdatePageParams params = new UpdatePageParams(
        site, cmd.getPage(), cmd.getPath(), cmd.getTitle(), layout, cmd.getDescription());
    Page page = this.pageService.update(params);
    PageDto dto = this.pageDtoConverter.convert(page);

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }
}
