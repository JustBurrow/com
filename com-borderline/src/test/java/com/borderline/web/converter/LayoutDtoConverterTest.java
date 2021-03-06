package com.borderline.web.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.borderline.BorderlineModuleTestConfiguration;
import com.borderline.web.dto.LayoutDto;
import com.domain.web.Layout;
import com.service.web.LayoutService;
import com.util.provider.TimeProvider;

/**
 * @author justburrow
 * @since 2017. 4. 12.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BorderlineModuleTestConfiguration.class)
@SpringBootTest
@Transactional
public class LayoutDtoConverterTest {
  @Autowired
  private LayoutDtoConverter layoutDtoConverter;
  @Autowired
  private LayoutService      layoutService;
  @Autowired
  private TimeProvider       timeProvider;

  @Before
  public void setUp() throws Exception {
    assertThat(this.layoutDtoConverter).isNotNull();
    assertThat(this.layoutService).isNotNull();
    assertThat(this.timeProvider).isNotNull();
  }

  @Test
  public void testConvertWithExampleData() throws Exception {
    // Given
    final Layout layout = this.layoutService.read(1);

    // When
    final LayoutDto dto = this.layoutDtoConverter.convert(layout);

    // Then
    assertThat(dto)
        .isNotNull()
        .extracting(LayoutDto::getId, LayoutDto::getLayoutTemplate, LayoutDto::getDescription,
            LayoutDto::getCreate, LayoutDto::getUpdate)
        .containsExactly(layout.getId(), layout.getLayoutTemplate(), layout.getDescription(),
            this.timeProvider.toLocalDteTime(layout.getCreate()),
            this.timeProvider.toLocalDteTime(layout.getUpdate()));
  }
}
