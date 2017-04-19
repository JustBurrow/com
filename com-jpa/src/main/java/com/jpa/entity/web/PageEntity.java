package com.jpa.entity.web;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.domain.base.Content;
import com.domain.web.Layout;
import com.domain.web.Page;
import com.domain.web.Site;
import com.domain.web.WebObjectType;
import com.jpa.listener.TimestampEntityListener;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Entity(name = "Page")
@EntityListeners({ TimestampEntityListener.class })
@Table(name = "master_page",
    uniqueConstraints = { @UniqueConstraint(name = "UQ_PAGE", columnNames = { "site", "path" }) })
public class PageEntity extends AbstractWebObject implements Page {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int    id;
  @ManyToOne(targetEntity = SiteEntity.class)
  @JoinColumn(name = "site",
      foreignKey = @ForeignKey(name = "FK_PAGE_PK_SITE"),
      referencedColumnName = "id",
      nullable = false,
      updatable = false)
  private Site   site;
  @Column(name = "path", nullable = false)
  private String path;
  @Column(name = "title", nullable = false)
  private String title;
  @ManyToOne(targetEntity = LayoutEntity.class)
  @JoinColumn(name = "layout",
      foreignKey = @ForeignKey(name = "FK_PAGE_PK_LAYOUT"),
      referencedColumnName = "id",
      nullable = false)
  private Layout layout;

  private PageEntity() {
  }

  public PageEntity(Site site) {
    this.site = site;
  }

  public PageEntity(Site site, String path) {
    this(site);
    this.setPath(path);
  }

  public PageEntity(Site site, String path, String title, Layout layout) {
    this(site, path);
    this.setTitle(title);
    this.setLayout(layout);
  }

  public PageEntity(Site site, String path, String title, Layout layout, String description) {
    this(site, path, title, layout);
    this.setDescription(description);
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public WebObjectType getType() {
    return WebObjectTypes.PAGE;
  }

  @Override
  public Site getSite() {
    return this.site;
  }

  @Override
  public String getPath() {
    return this.path;
  }

  @Override
  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public Layout getLayout() {
    return this.layout;
  }

  @Override
  public void setLayout(Layout layout) {
    this.layout = layout;
  }

  @Override
  public Map<String, Content> getContents() {
    return null;
  }

  @Override
  public Content getContent(String name) {
    return null;
  }

  @Override
  public Content setContent(String name, Content content) {
    return null;
  }

  @Override
  public int hashCode() {
    return this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if (0 < this.id && null != obj && obj instanceof PageEntity) {
      return this.id == ((PageEntity) obj).id;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return this.toString(PageEntity.class, new StringBuilder()
        .append("url=").append(this.getUrl())
        .append(", title=").append(this.title));
  }
}
