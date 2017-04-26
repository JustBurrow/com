package com.jpa.repository;

import com.jpa.entity.web.FractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@Repository
public interface FractionRepository extends JpaRepository<FractionEntity, Integer> {
}
