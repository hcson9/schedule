/*
 * Created by Hochan Son on 2025. 5. 14.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 14.
 */

package kr.spartacodingclub.demo2.service;

import kr.spartacodingclub.demo2.dto.ScheduleRequest;
import kr.spartacodingclub.demo2.dto.ScheduleResponse;
import kr.spartacodingclub.demo2.entity.Schedule;
import kr.spartacodingclub.demo2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
@RequiredArgsConstructor
public class ScheduleService {
  private final ScheduleRepository scheduleRepository;

  // 1. 외부에서 데이터를 받아서
  // 2. Schedule 생성해서
  // 3. DB 에 저장한다.
  public ScheduleResponse save(String content) {
    // 2번 스케쥴을 생성
    Schedule schedule = new Schedule(content);

    // 3번 DB 에 저장
    schedule = scheduleRepository.save(schedule);

    return new ScheduleResponse(schedule.getId(),
            schedule.getContent(),
            schedule.getCreatedAt());
  }

  public ScheduleResponse findById(Long id) {
    Schedule schedule = scheduleRepository.findScheduleById(id);

    return new ScheduleResponse(schedule.getId(),
            schedule.getContent(),
            schedule.getCreatedAt());
  }

  /**
   * <p>
   *   전체 찾기.
   * </p>
   *
   * @return 조회된 응답.
   */
  public List<ScheduleResponse> findAll() {
    List<Schedule> schedules = scheduleRepository.findAll(); // 1
    List<ScheduleResponse> scheduleResponses = new ArrayList<>(); // 1

    for (Schedule schedule : schedules) {
      scheduleResponses.add(new ScheduleResponse(schedule.getId(),
              schedule.getContent(),
              schedule.getCreatedAt()));
    }

    return scheduleResponses;
//    return schedules.stream()
//            .map(schedule -> new ScheduleResponse(schedule.getId(), schedule.getContent(), schedule.getCreatedAt()))
//            .toList();
  }

  public void deleteById(Long id) {
    Schedule schedule = scheduleRepository.findScheduleById(id);
    scheduleRepository.delete(schedule);
  }

//  private Schedule findScheduleById(Long id) {
//    return scheduleRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("schedule not found"));
//  }

  public ScheduleResponse update(Long id, String content) {
    Schedule schedule = scheduleRepository.findById(id)
            .orElseThrow();
    schedule.update(content);
    scheduleRepository.save(schedule);
    return new ScheduleResponse(schedule.getId(),
            schedule.getContent(),
            schedule.getCreatedAt());
  }
}
