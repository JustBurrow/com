package com.borderline;

import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.dto.PageDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface PageBorderline {
  /**
   * @param cmd
   * @return
   */
  PageDto create(CreatePageCmd cmd);
}
