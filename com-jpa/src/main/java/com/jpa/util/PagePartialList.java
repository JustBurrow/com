package com.jpa.util;

import com.util.data.PartialList;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * {@link org.springframework.data.domain.Page} 래퍼.
 *
 * @param <T>
 * @author justburrow
 * @see org.springframework.data.domain.Page
 * @since 2017. 4. 2.
 */
public class PagePartialList<T> implements PartialList<T> {
  private Page<T> page;

  public PagePartialList(Page<T> page) {
    this.page = page;
  }

  @Override
  public int getTotalPages() {
    return this.page.getTotalPages();
  }

  @Override
  public long getTotalElements() {
    return this.page.getTotalElements();
  }

  @Override
  public int getPage() {
    return this.page.getNumber();
  }

  @Override
  public int getSize() {
    return this.page.getSize();
  }

  @Override
  public boolean isFirst() {
    return this.page.isFirst();
  }

  @Override
  public boolean isLast() {
    return this.page.isLast();
  }

  @Override
  public boolean hasPrevious() {
    return this.page.hasPrevious();
  }

  @Override
  public boolean hasNext() {
    return this.page.hasNext();
  }

  @Override
  public List<T> getContent() {
    return this.page.getContent();
  }
}
