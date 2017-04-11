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
   * @return
   */
  String getTemplate();

  /**
   * @param template
   */
  void setTemplate(String template);

  /**
   * @param req
   * @return
   */
  ContentContext buildContext(GenericReq req);
}
