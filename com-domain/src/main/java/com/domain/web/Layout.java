package com.domain.web;

import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Layout extends WebObject {
  /**
   * @return
   */
  Site getSite();

  /**
   * @return
   */
  String getLayoutTemplate();

  /**
   * @return
   */
  Map<String, Fraction> getFractions();

  /**
   * @param name
   * @return
   */
  Fraction getFraction(String name);

  /**
   * @param fraction
   * @return
   */
  Fraction setFraction(Fraction fraction);
}
