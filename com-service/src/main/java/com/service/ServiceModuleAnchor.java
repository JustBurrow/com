package com.service;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public abstract class ServiceModuleAnchor {
  public static final Package PACKAGE      = ServiceModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected ServiceModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
