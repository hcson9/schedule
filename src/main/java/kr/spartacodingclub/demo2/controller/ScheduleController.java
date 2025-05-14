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

import kr.spartacodingclub.demo2.dto.ScheduleRequest;
import kr.spartacodingclub.demo2.dto.ScheduleResponse;
import kr.spartacodingclub.demo2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


  @PostMapping
  public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody ScheduleRequest scheduleRequest) {
    ScheduleResponse response = scheduleService.save(scheduleRequest.getContent());
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ScheduleResponse> findById(@PathVariable Long id) {
    ScheduleResponse response = scheduleService.findById(id);
    return ResponseEntity.ok(response);
  }
}
