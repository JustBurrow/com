package com.jpa.entity.web;

import com.domain.web.WebObjectType;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public enum WebObjectTypes implements WebObjectType {
  SITE,
  PAGE,
  LAYOUT,
  VIEW;

  @Override
  public int getId() {
    return ordinal();
  }

  @Override
  public String getName() {
    return name();
  }
}
