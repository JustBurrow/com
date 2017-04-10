package com.service.web;

import com.domain.web.Page;
import com.service.web.params.CreatePageParams;
import com.service.web.params.UpdatePageParams;
import org.springframework.transaction.annotation.Transactional;

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
   *
   * @param params
   * @return
   */
  Page update(UpdatePageParams params);
}
