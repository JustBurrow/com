package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreatePageReq;
import com.app.editor.web.exception.HttpException;
import com.borderline.PageBorderline;
import com.borderline.web.LayoutBorderline;
import com.borderline.web.SiteBorderline;
import com.borderline.web.cmd.CreatePageCmd;
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

    return format("redirect:/pages/%d/%d", siteId, page.getId());
  }
}
