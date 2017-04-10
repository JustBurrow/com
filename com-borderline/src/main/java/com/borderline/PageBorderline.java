package com.borderline;

import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.cmd.ReadPageCmd;
import com.borderline.web.cmd.UpdatePageCmd;
import com.borderline.web.dto.PageDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;

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
  PageDto read(ReadPageCmd cmd);

  /**
   * @param url
   * @return
   */
  PageDto read(URL url);

  /**
   * @param cmd
   * @return
   */
  PageDto update(UpdatePageCmd cmd);
}
