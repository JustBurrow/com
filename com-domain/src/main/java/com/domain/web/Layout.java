package com.domain.web;

import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Layout {
  /**
   * @return
   */
  String getName();

  Map<String, View> getViews();

  View getView(String name);

  View setView(String name, View view);
}
