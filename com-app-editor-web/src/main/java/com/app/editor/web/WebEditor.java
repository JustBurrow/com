package com.app.editor.web;

import com.borderline.BorderlineModuleAnchor;
import com.domain.DomainModuleAnchor;
import com.jpa.JpaModuleAnchor;
import com.service.ServiceModuleAnchor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@SpringBootApplication(scanBasePackageClasses = {
    WebEditorModuleAnchor.class,
    BorderlineModuleAnchor.class,
    ServiceModuleAnchor.class,
    JpaModuleAnchor.class,
    DomainModuleAnchor.class
})
public class WebEditor {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(WebEditor.class, args);
  }
}
