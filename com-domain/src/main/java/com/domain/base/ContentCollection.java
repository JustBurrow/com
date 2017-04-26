package com.domain.base;


import com.util.data.PartialList;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface ContentCollection<V> {
  /**
   * @return 기본 페이지 크기.
   */
  int getDefaultPageSize();

  /**
   * @param page 0-base.
   * @param size 페이지의 아이템 수.
   * @return 페이지.
   */
  PartialList<V> getContent(int page, int size);

  /**
   * 기본 페이지 크기를 사용해 페이지를 조회한다.
   *
   * @param page 0-base.
   * @return 페이지.
   */
  default PartialList<V> getContent(int page) {
    return getContent(page, getDefaultPageSize());
  }

  /**
   * @param value
   */
  void add(V value);
}
