package com.domain.base;

import com.util.Updatable;

/**
 * 기본 자룡형.
 *
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Content extends Updatable {
  long getId();

  ContentType getType();

  String getDescription();

  void setDescription(String description);
}
