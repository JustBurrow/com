package com.borderline.web;

import com.borderline.web.dto.LayoutDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface LayoutBorderline {
  /**
   * @param siteId
   * @return
   */
  List<LayoutDto> list(int siteId);

  /**
   * @param id
   * @return
   */
  LayoutDto read(int id);
}
