package com.jpa.repository;

import com.domain.web.Page;
import com.domain.web.Site;
import com.jpa.JpaModuleTestConfiguration;
import com.jpa.entity.web.PageEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;

import static com.jpa.JpaModuleTestConfiguration.RANDOM;
import static com.jpa.repository.SiteRepositoryTest.randomSite;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaModuleTestConfiguration.class)
@DataJpaTest
public class PageRepositoryTest {
  @Autowired
  private PageRepository pageRepository;
  @Autowired
  private SiteRepository siteRepository;

  private Instant before;

  public static PageEntity randomPage(Site site) {
    StringBuilder path = new StringBuilder('/').append(randomAlphabetic(1, 10));
    for (int i = 0; i < 5 && RANDOM.nextBoolean(); i++) {
      path.append('/').append(randomAlphabetic(1, 10));
    }
    String title = "jpa test title #"+randomAlphanumeric(5, 10);
    String dexcription = "jpa test page #" + randomAlphabetic(5, 9);
    return new PageEntity(site, path.toString(), title, dexcription);
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.pageRepository).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testFindAll() throws Exception {
    // When
    List<PageEntity> list = this.pageRepository.findAll();

    // Then
    assertThat(list)
        .isNotNull();
  }

  @Test
  public void testSave() throws Exception {
    // Given
    Site       site     = this.siteRepository.save(randomSite());
    PageEntity expected = randomPage(site);

    // When
    PageEntity actual = this.pageRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(Page::getSite, Page::getPath, Page::getDescription)
        .containsExactly(site, expected.getPath(), expected.getDescription());
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
