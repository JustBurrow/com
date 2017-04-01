package com.jpa.repository;

public abstract class RepositoryAnchor {
  public static final Package PACKAGE      = RepositoryAnchor.class.getPackage();
  public static final String  PACKAGE_NAME = PACKAGE.getName();

  private RepositoryAnchor() {
    throw new UnsupportedOperationException();
  }
}
