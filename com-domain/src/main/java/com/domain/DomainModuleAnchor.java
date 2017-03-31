package com.domain;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public abstract class DomainModuleAnchor {
  public static final Package PACKAGE      = DomainModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected DomainModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
