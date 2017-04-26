package com.service.web.dao;

import com.domain.web.Layout;
import com.domain.web.Site;
import com.jpa.entity.web.LayoutEntity;
import com.jpa.entity.web.SiteEntity;
import com.jpa.repository.LayoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Service
public class LayoutDaoImpl implements LayoutDao {
  private static final Logger log = LoggerFactory.getLogger(LayoutDao.class);

  @Autowired
  private LayoutRepository layoutRepository;

  @Override
  public List<Layout> list(Site site) {
    if (log.isDebugEnabled()) {
      log.debug(format("start=%s", site));
    }

    List<Layout> list = new ArrayList<>(this.layoutRepository.findAllBySite((SiteEntity) site));

    if (log.isDebugEnabled()) {
      log.debug(format("list=%s", list));
    }
    return list;
  }

  @Override
  public Layout read(int id) {
    if(log.isDebugEnabled()){
      log.debug(format("id=%d", id));
    }

    LayoutEntity layout = layoutRepository.findOne(id);

    if(log.isDebugEnabled()){
      log.debug(format("layout=%s", layout));
    }
    return layout;
  }
}
