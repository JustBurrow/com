package com.service.web;

import com.domain.web.Layout;
import com.domain.web.Site;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional
public interface LayoutService {
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
