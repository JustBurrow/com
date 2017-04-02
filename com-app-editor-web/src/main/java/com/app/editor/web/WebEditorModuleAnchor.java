package com.app.editor.web;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public abstract class WebEditorModuleAnchor {
  public static final Package PACKAGE      = WebEditorModuleAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  protected WebEditorModuleAnchor() {
    throw new UnsupportedOperationException();
  }
}
