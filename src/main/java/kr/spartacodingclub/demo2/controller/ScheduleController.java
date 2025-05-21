/*
 * Created by Hochan Son on 2025. 5. 14.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 14.
 */

package kr.spartacodingclub.demo2.controller;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import kr.spartacodingclub.demo2.dto.ScheduleRequest;
import kr.spartacodingclub.demo2.dto.ScheduleResponse;
import kr.spartacodingclub.demo2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
  private final ScheduleService scheduleService;

  // 등록
  @PostMapping
  public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody @Valid ScheduleRequest scheduleRequest) {
    ScheduleResponse response = scheduleService.save(scheduleRequest.getContent());
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
  }

  // id 조회
  @GetMapping("/{id}")
  public ResponseEntity<ScheduleResponse> findById(@PathVariable Long id) {
    ScheduleResponse response = scheduleService.findById(id);
    return ResponseEntity.ok(response);
  }

  // 전체 조회
  @GetMapping
  public ResponseEntity<List<ScheduleResponse>> findAll() {
    return ResponseEntity.ok(scheduleService.findAll());
  }

  // 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    scheduleService.deleteById(id);
    return ResponseEntity.ok("Success");
  }

  // 전체 수정
  @PutMapping("/{id}")
  public ResponseEntity<ScheduleResponse> updateById(@PathVariable Long id,
                                                     @RequestBody ScheduleRequest scheduleRequest) {
    return ResponseEntity.ok(scheduleService.update(id, scheduleRequest.getContent()));
  }
}
