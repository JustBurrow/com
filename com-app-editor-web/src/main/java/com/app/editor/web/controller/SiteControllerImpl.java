package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreateSiteReq;
import com.domain.web.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 3.
 */
@Controller class SiteControllerImpl implements SiteController {
  private static final Logger log = LoggerFactory.getLogger(SiteController.class);

  @Override
  public String createForm(Model model) {
    if (log.isDebugEnabled()) {
      log.debug(format("model=%s", model));
    }
    if (null == model) {
      throw new IllegalArgumentException(new NullPointerException("model"));
    }

    model.addAttribute("createReq", new CreateSiteReq());
    model.addAttribute("protocolValues", Protocol.values());

    return "editor/site/siteCreate";
  }
}
