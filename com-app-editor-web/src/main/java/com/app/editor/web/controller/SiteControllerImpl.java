package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreateSiteReq;
import com.app.editor.web.exception.HttpException;
import com.borderline.web.SiteBorderline;
import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.dto.SiteDto;
import com.domain.web.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.List;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 3.
 */
@Controller class SiteControllerImpl implements SiteController {
  private static final Logger log = LoggerFactory.getLogger(SiteController.class);

  @Autowired
  private SiteBorderline siteBorderline;

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

  @Override
  public String create(@ModelAttribute @Valid final CreateSiteReq req, final BindingResult result, final Model model)
      throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("req=%s, result=%s, model=%s", req, result, model));
    }
    if (result.hasErrors()) {
      model.addAttribute("createReq", req);
      model.addAttribute("protocolValues", Protocol.values());
      if (log.isDebugEnabled()) {
        log.debug(format("model=%s", model));
      }
      return "editor/site/siteCreate";
    }

    Protocol protocol = Protocol.valueOf(req.getProtocol());

    CreateSiteCmd cmd = null;
    try {
      cmd = new CreateSiteCmd(protocol, req.getHost(), req.getDescription());
    } catch (MalformedURLException e) {
      model.addAttribute("createReq", req);
      model.addAttribute("protocolValues", Protocol.values());
      return "editor/site/siteCreate";
    }
    SiteDto site = this.siteBorderline.create(cmd);

    return "redirect:/sites";
  }

  @Override
  public String index(final Model model)
      throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("before model : %s", model));
    }

    List<SiteDto> list = this.siteBorderline.list();
    model.addAttribute("siteList", list);

    if (log.isDebugEnabled()) {
      log.debug(format("after model : %s", model));
    }
    return "editor/site/siteIndex";
  }
}
