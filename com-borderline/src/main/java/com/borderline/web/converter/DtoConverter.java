package com.borderline.web.converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <S> source type
 * @param <D> dto type
 * @param <C> converter context.
 * @author justburrow
 * @since 2017. 4. 9.
 */
public interface DtoConverter<S, D, C extends DtoConvertContext> {
  /**
   * @param src
   * @return
   */
  D convert(S src);

  /**
   * @param src
   * @param context
   * @return
   */
  D convert(S src, C context);

  /**
   * @param src
   * @return
   */
  default List<D> convert(List<S> src) {
    return src.stream().map(source -> convert(source)).collect(Collectors.toList());
  }
}
