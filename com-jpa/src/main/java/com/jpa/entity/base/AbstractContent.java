package com.jpa.entity.base;

import com.domain.base.Content;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Objects;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@MappedSuperclass
public abstract class AbstractContent implements Content {
  @Column(name = "description", length = 512)
  private String  description;
  @Column(name = "create_utc", nullable = false, updatable = false)
  private Instant create;
  @Column(name = "update_utc", nullable = false)
  private Instant update;

  /**
   * 자식 클래스의 {@link #toString()}을 사용하기 쉽게 만드는 유틸리티 메서드.
   * 공통 필드에 대한 포맷을 제공한다.
   *
   * @param clz {@link #toString()}을 사용하는 인스턴스의 클래스.
   * @param sub 자식 클래스의 데이터. ',' 구분. <b>id를 포함해 {@link AbstractContent}에서 처리하는 필드는 포함하지 말 것.</b>
   * @return
   */
  protected StringBuilder toString(Class<? extends AbstractContent> clz, CharSequence sub) {
    StringBuilder sb = new StringBuilder(clz.getSimpleName())
        .append("{id=").append(this.getId())
        .append(", description=").append(this.description);

    if (null != sub && 0 < sub.length()) {
      sb.append(", ").append(sub);
    }

    sb.append(", create=").append(this.create)
      .append(", update=").append(this.update)
      .append('}');
    return sb;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public Instant getCreate() {
    return this.create;
  }

  @Override
  public Instant getUpdate() {
    return this.update;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }

  @Override
  public boolean equals(Object obj) {
    if (0L < this.getId() && null != obj && obj instanceof AbstractContent) {
      return this.getId() == ((AbstractContent) obj).getId();
    } else {
      return false;
    }
  }
}
