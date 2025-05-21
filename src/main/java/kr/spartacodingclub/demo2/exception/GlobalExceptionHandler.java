/*
 * Created by Hochan Son on 2025. 5. 21.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 21.
 */

package kr.spartacodingclub.demo2.exception;

import kr.spartacodingclub.demo2.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * create on 2025. 5. 21. create by IntelliJ IDEA.
 * create by IntelliJ IDEA.
 *
 * <p> 클래스 설명. </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Hochan Son
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(exception = CustomException.class)
  public ResponseEntity<String> handleCustomException(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Custom " + exception.getMessage());
  }

  @ExceptionHandler(exception = RuntimeException.class)
  public ResponseEntity<String> handleException(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(exception.getMessage());
  }
}
