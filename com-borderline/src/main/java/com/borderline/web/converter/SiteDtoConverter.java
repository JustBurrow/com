package com.borderline.web.converter;

import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public interface SiteDtoConverter {
  /**
   * @param site
   * @return
   */
  SiteDto convert(Site site);

  /**
   * @param sites
   * @return
   */
  List<SiteDto> convert(List<Site> sites);
}
