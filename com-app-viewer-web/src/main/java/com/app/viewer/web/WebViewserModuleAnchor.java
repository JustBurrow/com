package com.app.viewer.web;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
public abstract class WebViewserModuleAnchor {
  public static final Package PACKAGE = WebViewserModuleAnchor.class.getPackage();
  public static final String PACKAGE_NAME = PACKAGE.getName();

  protected WebViewserModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
