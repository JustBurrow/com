package com.app.editor.web.controller;

import com.app.editor.web.WebEditorModuleTestConfiguration;
import com.app.editor.web.controller.req.CreateSiteReq;
import com.util.provider.TimeProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author justburrow
 * @since 2017. 4. 5.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebEditorModuleTestConfiguration.class)
@WebMvcTest(SiteController.class)
public class SiteControllerTest {
  @Autowired
  private MockMvc      mvc;
  @Autowired
  private TimeProvider timeProvider;

  private LocalDateTime before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.timeProvider).isNotNull();
    this.before = this.timeProvider.now(LocalDateTime.class);
  }

  @Test
  public void testCreateForm() throws Exception {
    // Given
    this.mvc.perform(get("/sites/create").accept(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML))
            .andExpect(status().isOk())
            .andExpect(model().attribute("createReq", new CreateSiteReq()))
            .andExpect(view().name("editor/site/siteCreate"));
  }
}
