package com.app.editor.web.controller;

import com.app.editor.web.exception.HttpException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@RequestMapping
public interface LandingController {
  @GetMapping
  String index(final Model model) throws HttpException;
}
