package com.app.editor.web;

import com.borderline.BorderlineModuleAnchor;
import com.jpa.JpaModuleAnchor;
import com.service.ServiceModuleAnchor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author justburrow
 * @since 2017. 4. 5.
 */
@SpringBootApplication(scanBasePackageClasses = {
    WebEditorModuleAnchor.class,
    BorderlineModuleAnchor.class,
    ServiceModuleAnchor.class,
    JpaModuleAnchor.class
})
@ComponentScan
public class WebEditorModuleTestConfiguration {
}
