package com.util;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public abstract class UtilModuleAnchor {
  public static final Package PACKAGE      = UtilModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected UtilModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
