package com.borderline.web;

import com.borderline.web.dto.SiteDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface SiteBorderline {
  List<SiteDto> list();
}
