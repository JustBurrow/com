package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreateSiteReq;
import com.app.editor.web.controller.req.UpdateSiteReq;
import com.app.editor.web.exception.HttpException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author justburrow
 * @since 2017. 4. 3.
 */
@RequestMapping("/sites")
public interface SiteController {
  /**
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping("/create")
  String createForm(final Model model) throws HttpException;

  /**
   * @param req
   * @param result
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping(method = RequestMethod.POST)
  String create(@ModelAttribute @Valid final CreateSiteReq req, final BindingResult result, final Model model)
      throws HttpException;

  /**
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping
  String index(Model model) throws HttpException;

  /**
   * @param id
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping(value = "/{id:[1-9]\\d*}", method = RequestMethod.GET)
  String detail(int id, Model model) throws HttpException;

  /**
   * @param id
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping("/{id:[1-9]\\d*}/edit")
  String updateForm(int id, Model model) throws HttpException;

  /**
   * @param req
   * @param result
   * @param model
   * @return
   * @throws HttpException
   */
  @RequestMapping(value = "/{id:[1-9]\\d*}", method = RequestMethod.PUT)
  String update(int id, UpdateSiteReq req, BindingResult result, Model model) throws HttpException;
}
