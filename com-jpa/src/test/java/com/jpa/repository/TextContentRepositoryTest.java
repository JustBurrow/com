package com.jpa.repository;

import com.domain.base.object.TextContent;
import com.jpa.JpaModuleTestConfiguration;
import com.jpa.entity.base.model.ContentModels;
import com.jpa.entity.base.object.TextContentEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static com.jpa.JpaModuleTestConfiguration.RANDOM;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 5. 3.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaModuleTestConfiguration.class)
@DataJpaTest
public class TextContentRepositoryTest {
  @Autowired
  private TextContentRepository textContentRepository;

  private Instant before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.textContentRepository).isNotNull();

    this.before = Instant.now();
  }

  @Test
  public void testSave() throws Exception {
    // Given
    final String            text     = RandomStringUtils.randomAlphanumeric(50 + RANDOM.nextInt(500));
    final TextContentEntity expected = new TextContentEntity(text);

    // When
    final TextContentEntity actual = this.textContentRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(TextContent::getModel, TextContent::getContent)
        .containsExactly(ContentModels.TEXT, text);
    assertThat(actual.getId()).isGreaterThan(0L);
    assertThat(actual.getCreate())
        .isNotNull()
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
