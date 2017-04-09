package com.util.data;

import java.util.List;

/**
 * @param <I> type of list item.
 * @author justburrow
 * @since 2017. 4. 9.
 */
public class SimplePartialList<I> implements PartialList<I> {
  /**
   *
   * @param sourceList
   * @param page
   * @param size
   * @param <I>
   * @return
   */
  public static <I> SimplePartialList<I> asPartialList(List<I> sourceList, int page, int size) {
    int totalPages = 1 +sourceList.size() / size;
    int from = page * size ;
    int to = Math.min(from +size, sourceList.size());
    return new SimplePartialList<>(totalPages, sourceList.size(), page, size, sourceList.subList(from, to));
  }

  private int     totalPages;
  private long    totalElements;
  private int     page;
  private int     capacity;
  private List<I> content;

  public SimplePartialList() {
  }

  /**
   * @param totalPages    전체 페이지 수. 0-base.
   * @param totalElements 전체 아이템 수.
   * @param page          현제 페이지. 0-base.
   * @param capacity      페이지별 최대 아이템 수.
   * @param content       페이지의 아이템 목록.
   */
  public SimplePartialList(int totalPages, long totalElements, int page, int capacity, List<I> content) {
    this.totalPages = totalPages;
    this.totalElements = totalElements;
    this.page = page;
    this.capacity = capacity;
    this.content = content;
  }

  @Override
  public int getTotalPages() {
    return this.totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public long getTotalElements() {
    return this.totalElements;
  }

  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }

  @Override
  public int getPage() {
    return this.page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  @Override
  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public int getSize() {
    return this.content.size();
  }

  @Override
  public boolean isFirst() {
    return 0 == this.page;
  }

  @Override
  public boolean isLast() {
    return this.totalPages == this.page;
  }

  @Override
  public boolean hasPrevious() {
    return 0 < this.page;
  }

  @Override
  public boolean hasNext() {
    return this.totalPages > this.page;
  }

  @Override
  public List<I> getContent() {
    return this.content;
  }

  public void setContent(List<I> content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return new StringBuffer()
        .append("{totalPages=").append(this.totalPages)
        .append(", totalElements=").append(this.totalElements)
        .append(", page=").append(this.page)
        .append(", capacity=").append(this.capacity)
        .append(", size=").append(null == this.content ? null : this.content.size())
        .append(", content=").append(this.content)
        .append('}').toString();
  }
}
