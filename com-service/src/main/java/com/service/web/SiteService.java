package com.service.web;

import com.domain.web.Site;
import com.service.web.params.CreateSiteParams;
import com.service.web.params.UpdateSiteParams;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Transactional
public interface SiteService {
  /**
   * 새로운 사이트 생성.
   *
   * @param params
   * @return
   */
  Site create(CreateSiteParams params);

  /**
   * 기본 정렬에 따른 전체 사이트 목록.
   *
   * @return 전체 목록.
   */
  List<Site> list();

  /**
   * @param id
   * @return
   */
  Site read(int id);

  /**
   *
   * @param url
   * @return
   */
  Site read(URL url);

  /**
   * @param params
   * @return
   */
  Site update(UpdateSiteParams params);
}
