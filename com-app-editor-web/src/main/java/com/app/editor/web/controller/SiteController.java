package com.app.editor.web.controller;

import com.app.editor.web.controller.req.CreateSiteReq;
import com.app.editor.web.controller.req.UpdateSiteReq;
import com.app.editor.web.exception.HttpException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
  @GetMapping("/create")
  String createForm(final Model model) throws HttpException;

  /**
   * @param req
   * @param result
   * @param model
   * @return
   * @throws HttpException
   */
  @PostMapping
  String create(@ModelAttribute @Valid final CreateSiteReq req, final BindingResult result, final Model model)
      throws HttpException;

  /**
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping
  String index(Model model) throws HttpException;

  /**
   * @param id
   * @param page
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping("/{id:[1-9]\\d*}")
  String detail(int id, int page, Model model) throws HttpException;

  /**
   * @param id
   * @param model
   * @return
   * @throws HttpException
   */
  @GetMapping("/{id:[1-9]\\d*}/edit")
  String updateForm(int id, Model model) throws HttpException;

  /**
   * @param req
   * @param result
   * @param model
   * @return
   * @throws HttpException
   */
  @PatchMapping("/{id:[1-9]\\d*}")
  String update(int id, UpdateSiteReq req, BindingResult result, Model model) throws HttpException;
}
