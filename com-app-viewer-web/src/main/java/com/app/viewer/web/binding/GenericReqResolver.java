package com.app.viewer.web.binding;

import com.domain.web.GenericReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
public class GenericReqResolver implements HandlerMethodArgumentResolver {
  private static final Logger log = LoggerFactory.getLogger(GenericReqResolver.class);

  @Override
  public boolean supportsParameter(MethodParameter param) {
    return param.getParameterType().equals(GenericReq.class);
  }

  @Override
  public Object resolveArgument(
      MethodParameter param, ModelAndViewContainer mav, NativeWebRequest request, WebDataBinderFactory binder)
      throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(format("param=%s, mav=%s, request=%s, binder=%s", param, mav, request, binder));
    }

    GenericReq req = new GenericReq();

    if (log.isDebugEnabled()) {
      log.debug(format("req=%s", req));
    }
    return req;
  }
}
