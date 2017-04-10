package com.app.viewer.web.controller;

import com.app.viewer.web.controller.req.GenericReq;
import com.borderline.PageBorderline;
import com.borderline.web.SiteBorderline;
import com.borderline.web.dto.PageDto;
import com.borderline.web.dto.SiteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URL;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@Controller class FrontControllerImpl implements FrontController {
  private static final Logger log = LoggerFactory.getLogger(FrontController.class);

  @Autowired
  private SiteBorderline siteBorderline;
  @Autowired
  private PageBorderline pageBorderline;

  @Override
  public String get(final URL url, final GenericReq req, final Model model) {
    if (log.isDebugEnabled()) {
      log.debug(format("url=%s, req=%s, model=%s", url, req, model));
    }

    SiteDto site = this.siteBorderline.read(url);
    model.addAttribute("site", site);

    PageDto page = this.pageBorderline.read(url);
    if (null == page) {
      throw new NullPointerException(format("url=%s", url));
    }
    model.addAttribute("page", page);

    if (log.isDebugEnabled()) {
      log.debug(format("after model : %s", model));
    }
    return format("viewer/site/%s-%s/page", url.getProtocol(), url.getHost());
  }


  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NullPointerException.class)
  public void handle(NullPointerException e) {
    if (log.isWarnEnabled()) {
      log.warn("no mapping", e);
    }
  }
}
