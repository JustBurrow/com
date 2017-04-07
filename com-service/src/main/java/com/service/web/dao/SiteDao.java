package com.service.web.dao;

import com.domain.web.Site;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface SiteDao {
  /**
   * @param site
   * @return
   */
  Site create(Site site);

  /**
   * @return
   */
  List<Site> listAll();

  /**
   *
   * @param id
   * @return
   */
  Site read(int id);
}
