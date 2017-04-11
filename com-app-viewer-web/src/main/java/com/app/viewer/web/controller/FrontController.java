package com.app.viewer.web.controller;

import com.domain.web.GenericReq;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@RequestMapping("/**")
public interface FrontController {
  @GetMapping
  public String get(URL url, GenericReq req, Model model);
}
