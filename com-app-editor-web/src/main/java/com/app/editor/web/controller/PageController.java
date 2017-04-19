package com.app.editor.web.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.editor.web.controller.req.CreatePageReq;
import com.app.editor.web.controller.req.UpdateFractionReq;
import com.app.editor.web.controller.req.UpdatePageReq;
import com.app.editor.web.exception.HttpException;

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

  /**
   * @param siteId
   * @param pageId
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping("/{siteId:[1-9]\\d*}/{pageId:[1-9]\\d*}")
  String detail(int siteId, int pageId, Model model) throws HttpException;

  /**
   * @param siteId
   * @param pageId
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping("/{siteId:[1-9]\\d*}/{pageId:[1-9]\\d*}/edit")
  String updateForm(int siteId, int pageId, Model model) throws HttpException;

  /**
   * @param siteId
   * @param pageId
   * @param req
   * @param binding
   * @param model
   * @return
   */
  @PatchMapping("/{siteId:[1-9]\\d*}/{pageId:[1-9]\\d*}")
  String update(int siteId, int pageId, UpdatePageReq req, BindingResult binding, Model model);

  /**
   * @param siteId
   * @param pageId
   * @param fractionName
   * @param req
   * @param binding
   * @param model
   * @return
   * @throws HttpException
   */
  @PatchMapping("/{siteId:[1-9]\\d*}/{pageId:[1-9]\\d*}/{fractionName:[a-z]\\w*}")
  String updateFraction(
      int siteId, int pageId, String fractionName,
      UpdateFractionReq req, BindingResult binding, Model model)
      throws HttpException;
}
