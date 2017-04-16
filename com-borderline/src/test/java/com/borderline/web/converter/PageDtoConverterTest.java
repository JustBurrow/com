/**
 *
 */
package com.borderline.web.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.borderline.BorderlineModuleTestConfiguration;
import com.borderline.PageBorderline;
import com.borderline.web.dto.FractionDto;
import com.borderline.web.dto.PageDto;
import com.domain.web.Page;
import com.service.web.PageService;
import com.util.provider.TimeProvider;

/**
 * @author justburrow
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BorderlineModuleTestConfiguration.class)
@SpringBootTest
@Transactional
public class PageDtoConverterTest {
  @Autowired
  private PageDtoConverter pageDtoConverter;
  @Autowired
  private TimeProvider     timeProvider;

  @Autowired
  private PageService    pageService;
  @Autowired
  private PageBorderline pageBorderline;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    assertThat(this.pageDtoConverter).isNotNull();
    assertThat(this.pageBorderline).isNotNull();
  }

  @Test
  public void testConvertWithExampleData() {
    // Given
    final Page page = this.pageService.read(1);

    // When
    PageDto dto = this.pageDtoConverter.convert(page);

    // Then
    assertThat(dto)
        .isNotNull()
        .extracting(PageDto::getId, PageDto::getDescription, PageDto::getCreate, PageDto::getUpdate)
        .containsExactly(page.getId(), page.getDescription(), this.timeProvider.toLocalDteTime(page.getCreate()),
            this.timeProvider.toLocalDteTime(page.getUpdate()));

    Map<String, FractionDto> fractions = dto.getFractions();
    assertThat(fractions).hasSize(4);
    assertThat(fractions.keySet()).contains("header", "content", "sidebar", "footer");
  }
}
