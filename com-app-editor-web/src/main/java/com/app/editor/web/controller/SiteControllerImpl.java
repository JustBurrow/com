package com.app.editor.web.controller;

import static java.lang.String.format;

import java.net.MalformedURLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.editor.web.controller.req.CreateSiteReq;
import com.app.editor.web.controller.req.UpdateSiteReq;
import com.app.editor.web.exception.HttpException;
import com.borderline.web.SiteBorderline;
import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.cmd.ReadSiteCmd;
import com.borderline.web.cmd.UpdateSiteCmd;
import com.borderline.web.dto.SiteDto;
import com.domain.web.Protocol;

/**
 * @author justburrow
 * @since 2017. 4. 3.
 */
@Controller
class SiteControllerImpl implements SiteController {
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

  @Override
  public String detail(
      @PathVariable("id") final int id,
      @RequestParam(name = "page", defaultValue = "1") int page, final Model model)
      throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d, model=%s", id, model));
    }

    SiteDto site = this.siteBorderline.read(id, --page);
    model.addAttribute("site", site);

    ReadSiteCmd cmd = new ReadSiteCmd(id, page);
    this.siteBorderline.read(cmd).getDtoMap().entrySet().forEach(e -> model.addAttribute(e.getKey(), e.getValue()));

    if (log.isDebugEnabled()) {
      log.debug(format("after model : %s", model));
    }
    return "editor/site/siteDetail";
  }

  @Override
  public String updateForm(@PathVariable("id") final int id, final Model model) throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("id=%d, model=%s", id, model));
    }

    SiteDto site = this.siteBorderline.read(id);
    model.addAttribute("site", site);

    UpdateSiteReq req = new UpdateSiteReq(site.getDescription());
    model.addAttribute("updateReq", req);

    if (log.isDebugEnabled()) {
      log.debug(format("after model : %s", model));
    }
    return "editor/site/siteEdit";
  }

  @Override
  public String update(@PathVariable("id") final int id, @ModelAttribute final UpdateSiteReq req,
      final BindingResult result, final Model model) throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("req=%s, result=%s, model=%s", req, result, model));
    }
    if (result.hasErrors()) {
      return "editor/site/siteEdit";
    }

    UpdateSiteCmd cmd = new UpdateSiteCmd(id, req.getDescription());
    SiteDto site = this.siteBorderline.update(cmd);
    String redirect = format("redirect:/sites/%d", site.getId());

    if (log.isDebugEnabled()) {
      log.debug(format("after redirect=%s, model=%s", redirect, model));
    }
    return redirect;
  }
}
