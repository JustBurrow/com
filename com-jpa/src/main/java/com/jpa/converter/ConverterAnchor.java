package com.jpa.converter;

public abstract class ConverterAnchor {
  public static final Package PACKAGE      = ConverterAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  private ConverterAnchor() {
    throw new UnsupportedOperationException();
  }
}
