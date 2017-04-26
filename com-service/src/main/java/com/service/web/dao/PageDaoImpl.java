package com.service.web.dao;

import com.domain.web.Page;
import com.domain.web.Site;
import com.jpa.entity.web.PageEntity;
import com.jpa.repository.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Service class PageDaoImpl implements PageDao {
  private static final Logger log = LoggerFactory.getLogger(PageDao.class);

  @Autowired
  private PageRepository pageRepository;

  @Override
  public Page create(Page page) {
    if (log.isDebugEnabled()) {
      log.debug(format("before page : %s", page));
    }

    page = this.pageRepository.save((PageEntity) page);

    if (log.isDebugEnabled()) {
      log.debug(format("after page : %s", page));
    }
    return page;
  }

  @Override
  public Page read(int id) {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d", id));
    }

    Page page = this.pageRepository.findOne(id);

    if (log.isDebugEnabled()) {
      log.debug(format("page=%s", page));
    }
    return page;
  }

  @Override
  public Page read(Site site, String path) {
    if (log.isDebugEnabled()) {
      log.debug(format("site=%s, path=%s", site, path));
    }

    PageEntity page = this.pageRepository.findOneBySiteAndPath(site, path);

    if (log.isDebugEnabled()) {
      log.debug(format("page=%s", page));
    }
    return page;
  }
}
