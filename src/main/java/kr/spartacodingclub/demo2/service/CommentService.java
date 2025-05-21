/*
 * Created by Hochan Son on 2025. 5. 19.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 19.
 */

package kr.spartacodingclub.demo2.service;

import kr.spartacodingclub.demo2.dto.CommentResponseDto;
import kr.spartacodingclub.demo2.entity.Comment;
import kr.spartacodingclub.demo2.entity.Schedule;
import kr.spartacodingclub.demo2.repository.CommentRepository;
import kr.spartacodingclub.demo2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentService {
  private final CommentRepository commentRepository;
  private final ScheduleRepository scheduleRepository;

  //
  @Transactional
  public CommentResponseDto save(String content, Long scheduleId) {
    // Schedule ->
    Schedule schedule = scheduleRepository.findScheduleById(scheduleId);

    Comment comment = new Comment(content, schedule);
    schedule.addComment(comment);
    return new CommentResponseDto(comment.getId(), comment.getContent());
  }

  public List<CommentResponseDto> findAll() {
    List<Comment> comments = commentRepository.findAll();

    return comments.stream()
            .map(comment -> new CommentResponseDto(comment.getId(), comment.getContent()))
            .collect(Collectors.toList());
  }

  public CommentResponseDto findById(Long id) {
    Comment comment = commentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("없습니다."));
    return new CommentResponseDto(comment.getId(), comment.getContent());
  }
}
