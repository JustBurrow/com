package com.jpa.repository;

import com.jpa.entity.base.object.TextContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2017. 5. 3.
 */
@Repository
public interface TextContentRepository extends JpaRepository<TextContentEntity, Long> {
}
