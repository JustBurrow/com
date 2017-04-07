package com.borderline.web;

import com.borderline.BorderlineModuleTestConfiguration;
import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.cmd.UpdateSiteCmd;
import com.borderline.web.dto.SiteDto;
import com.domain.web.Protocol;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.List;

import static com.borderline.BorderlineModuleTestConfiguration.RANDOM;
import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BorderlineModuleTestConfiguration.class)
@SpringBootTest
public class SiteBorderlineTest {
  @Autowired
  private SiteBorderline siteBorderline;
  private LocalDateTime  before;

  public static CreateSiteCmd randomCreateSiteCmd() throws MalformedURLException {
    Protocol protocol    = Protocol.valueOf(RANDOM.nextInt(2));
    String   domain      = format("%s.%s", randomAlphabetic(2, 10).toLowerCase(), randomAlphabetic(2, 4).toLowerCase());
    String   description = format("borderline test : random site #" + RANDOM.nextInt(Integer.MAX_VALUE));

    return new CreateSiteCmd(protocol, domain, description);
  }

  public static UpdateSiteCmd randomUpdateSiteCmd(SiteDto site) {
    return new UpdateSiteCmd(
        site.getId(),
        format("borderline test : new description #%d", RANDOM.nextInt(Integer.MAX_VALUE)));
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteBorderline).isNotNull();
    this.before = LocalDateTime.now();
  }

  @Test
  public void testCreateWithNull() throws Exception {
    assertThatThrownBy(() -> this.siteBorderline.create(null)).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testCreate() throws Exception {
    // Given
    CreateSiteCmd cmd = randomCreateSiteCmd();

    // When
    SiteDto dto = this.siteBorderline.create(cmd);

    // Then
    assertThat(dto)
        .isNotNull()
        .extracting(SiteDto::getUrl, SiteDto::getDescription)
        .containsExactly(cmd.getUrl(), cmd.getDescription());
    assertThat(dto.getCreate())
        .isAfterOrEqualTo(this.before)
        .isEqualTo(dto.getUpdate());
  }

  @Test
  public void testList() throws Exception {
    // When
    List<SiteDto> sites = this.siteBorderline.list();

    // Then
    assertThat(sites)
        .isNotNull();
  }

  @Test
  public void testRead() throws Exception {
    // Given
    CreateSiteCmd cmd = randomCreateSiteCmd();
    final int     id  = this.siteBorderline.create(cmd).getId();

    // When
    SiteDto actual = this.siteBorderline.read(id);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(SiteDto::getId, SiteDto::getUrl, SiteDto::getDescription)
        .containsExactly(id, cmd.getUrl(), cmd.getDescription());
    assertThat(actual.getCreate())
        .isAfterOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }

  @Test
  public void testUpdate() throws Exception {
    // Given
    final SiteDto expected = this.siteBorderline.create(randomCreateSiteCmd());
    UpdateSiteCmd cmd      = randomUpdateSiteCmd(expected);
    Thread.sleep(1L + RANDOM.nextInt(100));

    // When
    final SiteDto actual = this.siteBorderline.update(cmd);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(SiteDto::getId, SiteDto::getUrl, SiteDto::getDescription, SiteDto::getCreate)
        .containsExactly(expected.getId(), expected.getUrl(), cmd.getDescription(), expected.getCreate());
    assertThat(actual.getUpdate()).isAfter(this.before);
  }
}
