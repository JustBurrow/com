package com.borderline;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public abstract class BorderlineModuleAnchor {
  public static final Package PACKAGE      = BorderlineModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected BorderlineModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
