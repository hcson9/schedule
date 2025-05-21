/*
 * Created by Hochan Son on 2025. 5. 19.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 19.
 */

package kr.spartacodingclub.demo2.controller;

import kr.spartacodingclub.demo2.dto.CommentRequestDto;
import kr.spartacodingclub.demo2.dto.CommentResponseDto;
import kr.spartacodingclub.demo2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentResponseDto> create(@RequestBody CommentRequestDto requestDto) {
    CommentResponseDto responseDto = commentService.save(requestDto.getContent(), requestDto.getScheduleId());
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(responseDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id) {
    return ResponseEntity.ok(commentService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<CommentResponseDto>> findAll() {
    return ResponseEntity.ok(commentService.findAll());
  }
}
