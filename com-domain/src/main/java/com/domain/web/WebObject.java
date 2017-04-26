package com.domain.web;

import com.util.time.Updatable;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface WebObject extends Updatable {
  int getId();

  WebObjectType getType();

  String getDescription();

  void setDescription(String description);
}
