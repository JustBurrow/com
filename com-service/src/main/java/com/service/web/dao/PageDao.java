package com.service.web.dao;

import com.domain.web.Page;
import com.domain.web.Site;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface PageDao {
  /**
   * @param page
   * @return
   */
  Page create(Page page);

  /**
   * @param id
   * @return
   */
  Page read(int id);

  /**
   * @param site
   * @param path
   * @return
   */
  Page read(Site site, String path);
}
