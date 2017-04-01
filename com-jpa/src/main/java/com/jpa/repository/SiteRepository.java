package com.jpa.repository;

import com.jpa.entity.web.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, Integer> {
}
