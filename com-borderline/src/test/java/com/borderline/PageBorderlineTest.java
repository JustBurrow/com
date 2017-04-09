package com.borderline;

import com.borderline.web.LayoutBorderline;
import com.borderline.web.SiteBorderline;
import com.borderline.web.cmd.CreatePageCmd;
import com.borderline.web.dto.PageDto;
import com.util.provider.TimeProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BorderlineModuleTestConfiguration.class)
@SpringBootTest
public class PageBorderlineTest {
  @Autowired
  private PageBorderline   pageBorderline;
  @Autowired
  private SiteBorderline   siteBorderline;
  @Autowired
  private LayoutBorderline layoutBorderline;
  @Autowired
  private TimeProvider     timeProvider;

  private LocalDateTime before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.pageBorderline).isNotNull();
    assertThat(this.siteBorderline).isNotNull();

    this.before = this.timeProvider.now(LocalDateTime.class);
  }

  @Test
  public void testList() throws Exception {
    // Given
    final String        path        = randomAlphanumeric(5, 10);
    final String        title       = "page borderline test title #" + randomAlphanumeric(7, 10);
    final String        description = "page borderline test description #" + randomAlphanumeric(3, 10);
    final CreatePageCmd cmd         = new CreatePageCmd(1, path, title, 1, description);

    // When
    PageDto page = this.pageBorderline.create(cmd);

    // Then
    assertThat(page)
        .isNotNull()
        .extracting(PageDto::getSite, PageDto::getPath, PageDto::getTitle, PageDto::getDescription)
        .containsExactly(this.siteBorderline.read(1).getUrl(), path, title, description);
    assertThat(page.getId()).isGreaterThan(1);
    assertThat(page.getCreate())
        .isAfterOrEqualTo(this.before)
        .isEqualTo(page.getUpdate());
  }
}
