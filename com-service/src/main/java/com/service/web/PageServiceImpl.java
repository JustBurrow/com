package com.service.web;

import com.domain.web.Page;
import com.jpa.entity.web.PageEntity;
import com.service.web.dao.PageDao;
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
@Service class PageServiceImpl implements PageService {
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
}
