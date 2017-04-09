package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreatePageReq;
import com.app.editor.web.exception.HttpException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@RequestMapping("/pages")
public interface PageController {
  /**
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping("/{siteId:[1-9]\\d*}/create")
  String createForm(int siteId, final Model model) throws HttpException;

  /**
   * @param siteId
   * @param req
   * @param binding
   * @param model
   * @return
   * @throws HttpException
   */
  @PostMapping("/{siteId:[1-9]\\d*}")
  String create(int siteId, CreatePageReq req, BindingResult binding, Model model) throws HttpException;
}
