package com.domain.web;

import com.domain.base.ContentContext;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Fraction extends WebObject {
  /**
   * @return
   */
  String getName();

  /**
   * @param name
   */
  void setName(String name);

  /**
   * @param req
   * @return
   */
  ContentContext buildContext(GenericReq req);
}
