package com.service.web.dao;

import com.domain.web.Layout;
import com.domain.web.Site;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface LayoutDao {
  /**
   * @param site
   * @return
   */
  List<Layout> list(Site site);

  /**
   * @param id
   * @return
   */
  Layout read(int id);
}
