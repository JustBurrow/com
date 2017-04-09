package com.jpa.repository;

import com.domain.web.Layout;
import com.jpa.JpaModuleTestConfiguration;
import com.jpa.entity.web.LayoutEntity;
import com.jpa.entity.web.SiteEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static com.jpa.repository.SiteRepositoryTest.randomSite;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaModuleTestConfiguration.class)
@DataJpaTest
public class LayoutRepositoryTest {
  @Autowired
  private LayoutRepository layoutRepository;
  @Autowired
  private SiteRepository   siteRepository;

  private Instant before;

  public static LayoutEntity randomLayout(SiteEntity site) {
    String name        = randomAlphanumeric(10, 20);
    String description = "random layout #" + randomAlphanumeric(5, 10);
    return new LayoutEntity(site, name, description);
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.layoutRepository).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testFindAll() throws Exception {
    assertThat(this.layoutRepository.findAll())
        .isNotNull();
  }

  @Test
  public void testSaveWithRandom() throws Exception {
    // Given
    SiteEntity   site     = this.siteRepository.save(randomSite());
    LayoutEntity expected = randomLayout(site);

    // When
    LayoutEntity actual = this.layoutRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(Layout::getSite, Layout::getName, Layout::getDescription)
        .containsExactly(site, expected.getName(), expected.getDescription());
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
