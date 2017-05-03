package com.jpa.entity.base.model;

import com.domain.base.model.ContentModel;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author justburrow
 * @since 2017. 4. 30.
 */
public class ContentModelsTest {
  private Instant now;

  @Before
  public void setUp() throws Exception {
    this.now = Instant.now();
  }

  @Test
  public void testValues() throws Exception {
    for (ContentModels model : ContentModels.values()) {
      assertThat(model)
          .isNotNull()
          .extracting(ContentModel::getId, ContentModel::getDescription)
          .containsExactly((long) model.ordinal(), ContentModel.class.getName() + "." + model.name());
      assertThat(model.getCreate())
          .isNotNull()
          .isGreaterThan(Instant.EPOCH)
          .isLessThan(this.now);
      assertThatThrownBy(() -> model.setDescription("test description."))
          .isNotNull()
          .isInstanceOf(UnsupportedOperationException.class);
    }
  }
}
