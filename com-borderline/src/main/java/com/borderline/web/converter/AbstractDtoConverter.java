package com.borderline.web.converter;

import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.borderline.web.dto.WebObjectDto;
import com.domain.web.WebObject;
import com.util.data.PartialList;
import com.util.data.SimplePartialList;
import com.util.provider.TimeProvider;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
class AbstractDtoConverter {
  private static final Logger log = LoggerFactory.getLogger(AbstractDtoConverter.class);

  @Autowired
  private TimeProvider timeProvider;

  /**
   * @param src
   * @param dto
   * @param <D>
   * @return
   */
  protected <D extends WebObjectDto> D initialize(WebObject src, D dto) {
    if (log.isDebugEnabled()) {
      log.debug(format("source=%s", src));
    }

    dto.setId(src.getId());
    dto.setDescription(src.getDescription());
    dto.setCreate(this.timeProvider.toLocalDteTime(src.getCreate()));
    dto.setUpdate(this.timeProvider.toLocalDteTime(src.getUpdate()));

    if (log.isDebugEnabled()) {
      log.debug(format("dto=%s", dto));
    }
    return dto;
  }

  /**
   * @param source
   * @param converter
   * @param <S>
   * @param <D>
   * @return
   */
  protected <S, D> PartialList<D> convertPartialList(PartialList<S> source, DtoConverter<S, D> converter) {
    if (log.isDebugEnabled()) {
      log.debug(format("source=%s, converter=%s", source, converter));
    }

    PartialList<D> list = new SimplePartialList<>(
        source.getTotalPages(),
        source.getTotalElements(),
        source.getPage(),
        source.getCapacity(),
        converter.convert(source.getContent()));

    if (log.isDebugEnabled()) {
      log.debug(format("dto list : %s", list));
    }
    return list;
  }
}
