package com.jpa.entity.base.object;

import com.domain.base.model.ContentModel;
import com.domain.base.object.TextContent;
import com.jpa.entity.base.model.ContentModels;

import javax.persistence.*;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 30.
 */
@Entity(name = "TextContent")
@DiscriminatorValue("0")
@SecondaryTable(name = "master_content_object_text",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "id",
        foreignKey = @ForeignKey(name = "FK_OBJECT_TEXT_PK_OBJECT"),
        referencedColumnName = "id"))
public class TextContentEntity extends AbstractContentObject implements TextContent {
  @Column(name = "content_text", length = 1024)
  private String text;

  private TextContentEntity() {
  }

  public TextContentEntity(String text) {
    this.text = text;
  }

  @Override
  public ContentModel getModel() {
    return ContentModels.TEXT;
  }

  @Override
  public String getContent() {
    return this.text;
  }

  @Override
  public void setContent(String content) {
    this.text = content;
  }

  @Override
  public String toString() {
    return toString(TextContentEntity.class, format("text=%s", this.text)).toString();
  }
}
