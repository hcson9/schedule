/*
 * Created by Hochan Son on 2025. 5. 14.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 14.
 */

package kr.spartacodingclub.demo2.repository;

import kr.spartacodingclub.demo2.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

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
@Repository
public class ScheduleMapRepository implements ScheduleRepository {
  // id 를 부여
  private AtomicLong lastId = new AtomicLong(0);

  // 요청을 저장
  private Map<Long, Schedule> scheduleMap = new HashMap<>();

  @Override
  public Schedule save(Schedule schedule) {
    if (schedule.getId() == null) {
      schedule.setId(lastId.incrementAndGet()); // 1 증가시키고 값을 가져옴.
    }
    scheduleMap.put(schedule.getId(), schedule);
    return schedule;
  }

  @Override
  public Optional<Schedule> findById(Long id) {
    Schedule schedule = scheduleMap.get(id);
    return Optional.ofNullable(schedule);
  }

  @Override
  public List<Schedule> findAll() {
//    for (Long key : scheduleMap.keySet()) {
//      Schedule schedule = scheduleMap.get(key);
//    }

    return scheduleMap.values()
            .stream()
            .toList();
  }

  @Override
  public void delete(Schedule schedule) {
    scheduleMap.remove(schedule.getId());
  }

//  @Override
//  public void deleteById(Long id) {
//    if (!scheduleMap.containsKey(id)) {
//      throw new RuntimeException("없습니다.");
//    }
//    scheduleMap.remove(id);
//  }
}
