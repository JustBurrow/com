package com.jpa.repository;

import com.jpa.entity.web.LayoutEntity;
import com.jpa.entity.web.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Repository
public interface LayoutRepository extends JpaRepository<LayoutEntity, Integer> {
  /**
   * @param site
   * @return
   */
  List<LayoutEntity> findAllBySite(SiteEntity site);
}
