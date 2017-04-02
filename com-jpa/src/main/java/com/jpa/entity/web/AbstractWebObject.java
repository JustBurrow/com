package com.jpa.entity.web;

import com.domain.web.WebObject;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@MappedSuperclass
public abstract class AbstractWebObject implements WebObject {
  @Column(name = "description")
  private String  description;
  @Column(name = "create_utc", nullable = false, updatable = false)
  private Instant create;
  @Column(name = "update_utc", nullable = false)
  private Instant update;

  protected AbstractWebObject() {
  }

  protected AbstractWebObject(String description) {
    setDescription(description);
  }

  /**
   * 구현 클래스에만 있는 멤버를 인자로 받아 출력용 문자열을 만든다.
   * <p>
   * <p><b>하위 클래스 정보에서 ID는 제외할 것.</b><br/><b>DO NOT INCLUDE ID.</b></p>
   *
   * @param clz 구현 클래스.
   * @param str 구현 클래스의 인스턴스 정보. ID를 포함하지 말 것.
   * @return 전체 인스턴스 정보.
   */
  protected String toString(Class<? extends WebObject> clz, CharSequence str) {
    return new StringBuilder(clz.getSimpleName())
        .append("{id=").append(this.getId())
        .append(", description=").append(this.description)
        .append(", ").append(str)
        .append(", create=").append(this.create)
        .append(", update=").append(this.update)
        .append('}').toString();
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
    return this.getId();
  }
}
