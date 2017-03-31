package com.util;

import java.util.Iterator;
import java.util.List;

/**
 * {@code org.springframework.data.domain.Page}의존성 해소용 인터페이스.
 *
 * @param <I> 페이지 내용.
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface PartialList<I> {
  /**
   * @return 전체 페이지 수.
   */
  int getTotalPage();

  /**
   * @return 전체 아이템 수.
   */
  long getTotalElement();

  /**
   * @return 현재 페이지.
   */
  int getPage();

  /**
   * @return 현재 페이지의 아이템 수.
   */
  int getSize();

  /**
   * @return 현재 페이지가 첫 페이지인가.
   */
  boolean isFirst();

  /**
   * @return 현재 페이지가 마지막 페이지인가.
   */
  boolean isLast();

  /**
   * @return 이전 페이지가 있는가.
   */
  boolean hasPrevious();

  /**
   * @return 다음 페이지가 있는가.
   */
  boolean hasNext();

  /**
   * @return 아이템 목록.
   */
  List<I> getContent();

  /**
   * @return 아이템 이터레이터.
   */
  default Iterator<I> getIterator() {
    return getContent().iterator();
  }
}
