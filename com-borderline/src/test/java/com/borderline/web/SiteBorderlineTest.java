package com.borderline.web;

import com.borderline.BorderlineModuleTestConfiguration;
import com.borderline.web.cmd.CreateSiteCmd;
import com.borderline.web.dto.SiteDto;
import com.domain.web.Protocol;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

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

  private LocalDateTime before;

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
    CreateSiteCmd cmd = new CreateSiteCmd(Protocol.HTTP, "example.com");

    // When
    SiteDto dto = this.siteBorderline.create(cmd);

    // Then
    assertThat(dto)
        .isNotNull()
        .extracting(SiteDto::getUrl)
        .containsExactly(new URL("http://example.com"));
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
        .isNotNull()
        .isEmpty();
  }
}
