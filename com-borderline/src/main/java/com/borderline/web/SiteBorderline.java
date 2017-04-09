package com.borderline.web;

import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.cmd.UpdateSiteCmd;
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
  /**
   * 새로운 사이트 정보 생성.
   *
   * @param cmd
   * @return
   */
  SiteDto create(CreateSiteCmd cmd);

  /**
   * 사이트 목록
   *
   * @return
   */
  List<SiteDto> list();

  /**
   * @param id
   * @return
   */
  SiteDto read(int id);

  /**
   * @param id
   * @param page
   * @return
   */
  SiteDto read(int id, int page);

  /**
   * @param cmd
   * @return
   */
  SiteDto update(UpdateSiteCmd cmd);
}
