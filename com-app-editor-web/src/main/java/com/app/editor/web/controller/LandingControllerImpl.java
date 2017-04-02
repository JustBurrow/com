package com.app.editor.web.controller;

import com.app.editor.web.exception.HttpException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Controller
public class LandingControllerImpl implements LandingController {
  @Override
  public String index(final Model model) throws HttpException {
    return "editor/landing/index";
  }
}
