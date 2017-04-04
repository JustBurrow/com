package com.app.editor.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author justburrow
 * @since 2017. 4. 3.
 */
@RequestMapping("/sites")
public interface SiteController {
  /**
   * @param model
   * @return
   */
  @GetMapping("/create")
  String createForm(final Model model);
}
