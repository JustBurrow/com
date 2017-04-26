package com.jpa;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public abstract class JpaModuleAnchor {
  public static final Package PACKAGE      = JpaModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected JpaModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
