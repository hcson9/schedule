/*
 * Created by Hochan Son on 2025. 5. 14.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 14.
 */

package kr.spartacodingclub.demo2.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * create on 2025. 5. 14. create by IntelliJ IDEA.
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
@Getter
public class Schedule {

  @Setter
  private Long id;

  private String content;

  private String name;

  private LocalDateTime createdAt;

  public Schedule(String content) {
    this.content = content;
    this.createdAt = LocalDateTime.now();
  }

  public void update(String content) {
    this.content = content;
  }
}
