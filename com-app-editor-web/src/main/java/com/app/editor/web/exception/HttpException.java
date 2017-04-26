package com.app.editor.web.exception;

import org.springframework.http.HttpStatus;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public class HttpException extends Exception {
  private HttpStatus status;

  public HttpException(HttpStatus status) {
    this.status = status;
  }

  public HttpException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public HttpException(String message, Throwable cause, HttpStatus status) {
    super(message, cause);
    this.status = status;
  }

  public HttpException(Throwable cause, HttpStatus status) {
    super(cause);
    this.status = status;
  }

  public HttpStatus getStatus() {
    return this.status;
  }
}
