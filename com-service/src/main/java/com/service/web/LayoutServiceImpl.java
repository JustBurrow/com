package com.service.web;

import com.domain.web.Layout;
import com.domain.web.Site;
import com.service.web.dao.LayoutDao;
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
@Service class LayoutServiceImpl implements LayoutService {
  private static final Logger log = LoggerFactory.getLogger(LayoutService.class);

  @Autowired
  private LayoutDao layoutDao;

  @Override
  public List<Layout> list(Site site) {
    if (log.isDebugEnabled()) {
      log.debug(format("start=%s", site));
    }

    List<Layout> list = this.layoutDao.list(site);

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }

  @Override
  public Layout read(int id) {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d", id));
    }

    Layout layout = this.layoutDao.read(id);

    if (log.isDebugEnabled()) {
      log.debug(format("layout=%s", layout));
    }
    return layout;
  }
}
