package com.app.viewer.web.binding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
public class UrlResolver implements HandlerMethodArgumentResolver {
  private static final Logger log = LoggerFactory.getLogger(UrlResolver.class);

  @Override
  public boolean supportsParameter(MethodParameter param) {
    return param.getParameterType().equals(URL.class);
  }

  @Override
  public Object resolveArgument(
      MethodParameter param, ModelAndViewContainer mav, NativeWebRequest request, WebDataBinderFactory binder)
      throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(format("param=%s, mav=%s, request=%s, binder=%s", param, mav, request, binder));
    }

    URL url = new URL(request.getNativeRequest(HttpServletRequest.class).getRequestURL().toString());

    if (log.isDebugEnabled()) {
      log.debug(format("url=%s", url));
    }
    return url;
  }
}
