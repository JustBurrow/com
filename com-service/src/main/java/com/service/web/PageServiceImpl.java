package com.service.web;

import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.web.Fraction;
import com.domain.web.Page;
import com.domain.web.Site;
import com.jpa.entity.web.PageEntity;
import com.service.web.dao.PageDao;
import com.service.web.params.CreatePageParams;
import com.service.web.params.UpdateFractionParams;
import com.service.web.params.UpdatePageParams;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Service
class PageServiceImpl implements PageService {
  private static final Logger log = LoggerFactory.getLogger(PageService.class);

  @Autowired
  private PageDao pageDao;

  @Override
  public Page create(CreatePageParams params) {
    if (log.isDebugEnabled()) {
      log.debug(format("params=%s", params));
    }
    Page page = new PageEntity(params.getSite(), params.getPath(), params.getTitle(), params.getLayout());
    page.setDescription(params.getDescription());

    page = this.pageDao.create(page);

    if (log.isDebugEnabled()) {
      log.debug(format("page=%s", page));
    }
    return page;
  }

  @Override
  public Page read(int id) {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d", id));
    }

    Page page = this.pageDao.read(id);

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

    Page page = this.pageDao.read(site, path);

    if (log.isDebugEnabled()) {
      log.debug(format("page=%s", page));
    }
    return page;
  }

  @Override
  public Page update(UpdatePageParams params) {
    if (log.isDebugEnabled()) {
      log.debug(format("params=%s", params));
    }

    Page page = this.pageDao.read(params.getId());
    if (null == page) {
      return null;
    } else if (!page.getSite().equals(params.getSite())) {
      log.warn(format("params=%s, page=%s", params, page));
      return null;
    }

    page.setPath(params.getPath());
    page.setTitle(params.getTitle());
    page.setLayout(params.getLayout());
    page.setDescription(params.getDescription());

    return page;
  }

  @Override
  public Page update(UpdateFractionParams params) {
    if (log.isDebugEnabled()) {
      log.debug(format("params=%s", params));
    }

    Page page = this.pageDao.read(params.getPage());
    if (!page.getSite().equals(params.getSite())) {
      throw new IllegalArgumentException(format("page=%s, params=%s", page, params));
    }

    Fraction fraction = page.getLayout().getFraction(params.getFraction());
    fraction.setDescription(params.getDescription());

    if (log.isDebugEnabled()) {
      log.debug(format("page=%s, fraction=%s", page, fraction));
    }
    return page;
  }
}
