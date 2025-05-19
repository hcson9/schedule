/*
 * Created by Hochan Son on 2025. 5. 19.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 19.
 */

package kr.spartacodingclub.demo2.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * create on 2025. 5. 19. create by IntelliJ IDEA.
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
public class Comment {
  @Setter
  private Long id;

  private String content;

  private Schedule schedule;

//  public Comment(String content) {
//    this.content = content;
//  }

  public Comment(String content, Schedule schedule) {
    this.content = content;
    this.schedule = schedule;
  }
}
