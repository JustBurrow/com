package com.service.web;

import com.domain.web.Site;
import com.service.web.dao.SiteDao;
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
@Service class SiteServiceImpl implements SiteService {
  private static final Logger log = LoggerFactory.getLogger(SiteService.class);

  @Autowired
  private SiteDao siteDao;

  @Override
  public List<Site> list() {
    List<Site> list = this.siteDao.listAll();

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }
}
