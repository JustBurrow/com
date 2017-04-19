package com.service.web;

import org.springframework.transaction.annotation.Transactional;

import com.domain.web.Page;
import com.domain.web.Site;
import com.service.web.params.CreatePageParams;
import com.service.web.params.UpdateFractionParams;
import com.service.web.params.UpdatePageParams;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional
public interface PageService {
  /**
   * @param params
   * @return
   */
  Page create(CreatePageParams params);

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

  /**
   * @param params
   * @return
   */
  Page update(UpdatePageParams params);

  /**
   * @param params
   * @return
   */
  Page update(UpdateFractionParams params);
}
