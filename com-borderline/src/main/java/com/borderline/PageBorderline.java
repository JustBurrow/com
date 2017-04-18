package com.borderline;

import java.net.URL;

import com.domain.web.GenericReq;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.cmd.ReadPageCmd;
import com.borderline.web.cmd.UpdatePageCmd;
import com.borderline.web.dto.DtoMap;
import com.borderline.web.dto.PageDto;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface PageBorderline {
  /**
   * @param cmd
   * @return
   */
  PageDto create(CreatePageCmd cmd);

  /**
   * @param cmd
   * @return
   */
  DtoMap read(ReadPageCmd cmd);

  /**
   *
   * @param url
   * @param req
   * @return
   */
  DtoMap read(URL url, GenericReq req);

  /**
   * @param cmd
   * @return
   */
  PageDto update(UpdatePageCmd cmd);
}
