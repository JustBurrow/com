package com.service.web.dao;

import com.domain.web.Site;
import com.jpa.entity.web.SiteEntity;
import com.jpa.repository.SiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Service class SiteDaoImpl implements SiteDao {
  private static final Logger log = LoggerFactory.getLogger(SiteDao.class);

  @Autowired
  private SiteRepository siteRepository;

  @Override
  public Site create(Site site) {
    if (log.isDebugEnabled()) {
      log.debug(format("site before : %s", site));
    }

    site = this.siteRepository.save((SiteEntity) site);

    if (log.isDebugEnabled()) {
      log.debug(format("site after : %s", site));
    }
    return site;
  }

  @Override
  public List<Site> listAll() {
    List<Site> list = new ArrayList<>(this.siteRepository.findAllByOrderByIdAsc());

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }
}
