package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreatePageReq;
import com.app.editor.web.controller.req.UpdatePageReq;
import com.app.editor.web.exception.HttpException;
import com.borderline.PageBorderline;
import com.borderline.web.LayoutBorderline;
import com.borderline.web.SiteBorderline;
import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.cmd.ReadPageCmd;
import com.borderline.web.cmd.UpdatePageCmd;
import com.borderline.web.dto.PageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Controller class PageControllerImpl implements PageController {
  private static final Logger log = LoggerFactory.getLogger(PageController.class);

  @Autowired
  private PageBorderline   pageBorderline;
  @Autowired
  private SiteBorderline   siteBorderline;
  @Autowired
  private LayoutBorderline layoutBorderline;

  @Override
  public String createForm(@PathVariable("siteId") int siteId, Model model) throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("siteId=%d, model=%s", siteId, model));
    }

    model.addAttribute("site", this.siteBorderline.read(siteId));
    model.addAttribute("createReq", new CreatePageReq());
    model.addAttribute("layouts", this.layoutBorderline.list(siteId));

    return "editor/page/pageCreate";
  }

  @Override
  public String create(
      @PathVariable("siteId") final int siteId,
      @ModelAttribute final CreatePageReq req, final BindingResult binding, Model model)
      throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("siteId=%d, req=%s, binding=%s, model=%s", siteId, req, binding, model));
    }

    CreatePageCmd cmd = new CreatePageCmd(siteId, req.getPath(), req.getTitle(), req.getLayout(),
                                          req.getDescription());
    PageDto page = this.pageBorderline.create(cmd);

    return format("redirect:/pages/%d/%d/edit", siteId, page.getId());
  }

  @Override
  public String updateForm(
      @PathVariable("siteId") final int siteId,
      @PathVariable("pageId") final int pageId, final Model model)
      throws HttpException {
    if (log.isDebugEnabled()) {
      log.debug(format("siteId=%d, pageId=%d, model=%s", siteId, pageId, model));
    }

    ReadPageCmd cmd  = new ReadPageCmd(siteId, pageId);
    PageDto     page = this.pageBorderline.read(cmd);

    model.addAttribute("site", this.siteBorderline.read(siteId));
    model.addAttribute("page", page);

    UpdatePageReq req = new UpdatePageReq(
        page.getPath(), page.getTitle(), page.getLayout().getId(), page.getDescription());
    model.addAttribute("layouts", this.layoutBorderline.list(siteId));
    model.addAttribute("updateReq", req);

    if (log.isDebugEnabled()) {
      log.debug(format("after model : %s", model));
    }
    return "editor/page/pageEdit";
  }

  @Override
  public String update(
      @PathVariable("siteId") final int siteId,
      @PathVariable("pageId") int pageId,
      @ModelAttribute final UpdatePageReq req, final BindingResult binding, final Model model) {
    if (log.isDebugEnabled()) {
      log.debug(format("siteId=%d, pageId=%d, req=%s, binding=%s, model=%s", siteId, pageId, req, binding, model));
    }

    UpdatePageCmd cmd = new UpdatePageCmd(siteId, pageId, req.getPath(), req.getTitle(), req.getLayout(),
                                          req.getDescription());
    PageDto page = this.pageBorderline.update(cmd);
    if (null == page) {
      return "redirect:/";
    }

    return format("redirect:/pages/%d/%d/edit", siteId, pageId);
  }
}
