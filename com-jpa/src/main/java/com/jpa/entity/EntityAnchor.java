package com.jpa.entity;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public abstract class EntityAnchor {
  public static final Package PACKAGE      = EntityAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected EntityAnchor() {
    throw new UnsupportedOperationException();
  }
}
