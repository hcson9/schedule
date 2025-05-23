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
public class CustomException extends RuntimeException {

  public CustomException(String message) {
    super(message);
  }
}
