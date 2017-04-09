package com.jpa.repository;

import com.jpa.entity.web.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Repository
public interface PageRepository extends JpaRepository<PageEntity, Integer> {
}
