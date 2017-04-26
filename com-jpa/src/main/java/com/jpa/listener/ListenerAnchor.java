package com.jpa.listener;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public abstract class ListenerAnchor {
  public static final Package PACKAGE      = ListenerAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected ListenerAnchor() {
    throw new UnsupportedOperationException();
  }
}
