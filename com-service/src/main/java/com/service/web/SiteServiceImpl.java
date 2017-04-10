package com.service.web;

import com.domain.web.Protocol;
import com.domain.web.Site;
import com.jpa.entity.web.SiteEntity;
import com.service.web.dao.SiteDao;
import com.service.web.params.CreateSiteParams;
import com.service.web.params.UpdateSiteParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service class øSiteServiceImpl implements SiteService {
  private static final Logger log = LoggerFactory.getLogger(SiteService.class);

  @Autowired
  private SiteDao siteDao;

  @Override
  public Site create(CreateSiteParams params) {
    if (log.isDebugEnabled()) {
      log.debug(format("params=%s", params));
    }

    Site site = new SiteEntity(params.getUrl());
    site.setDescription(params.getDescription());
    site = this.siteDao.create(site);

    if (log.isDebugEnabled()) {
      log.debug(format("site created : %s", site));
    }
    return site;
  }

  @Override
  public List<Site> list() {
    List<Site> list = this.siteDao.listAll();

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }

  @Override
  public Site read(int id) {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d", id));
    }

    Site site = this.siteDao.read(id);

    if (log.isDebugEnabled()) {
      log.debug(format("site=%s", site));
    }
    return site;
  }

  @Override
  public Site read(URL url) {
    if (log.isDebugEnabled()) {
      log.debug(format("url=%s", url));
    }

    Protocol protocol = Protocol.valueOf(url);
    String   host     = url.getHost();

    Site site = this.siteDao.read(protocol, host);

    if (log.isDebugEnabled()) {
      log.debug(format("site=%s", site));
    }
    return site;
  }

  @Override
  public Site update(UpdateSiteParams params) {
    if (log.isDebugEnabled()) {
      log.debug(format("params=%s", params));
    }

    Site site = this.siteDao.read(params.getId());
    site.setDescription(params.getDescription());

    if (log.isDebugEnabled()) {
      log.debug(format("site=%s", site));
    }
    return site;
  }
}
