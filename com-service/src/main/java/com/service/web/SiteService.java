package com.service.web;

import com.domain.web.Site;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Transactional
public interface SiteService {
  /**
   * 기본 정렬에 따른 전체 사이트 목록.
   *
   * @return 전체 목록.
   */
  List<Site> list();
}
