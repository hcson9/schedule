package kr.spartacodingclub.demo2.service;/*
 * Created by Hochan Son on 2025. 5. 22.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 22.
 */

import kr.spartacodingclub.demo2.dto.ScheduleResponse;
import kr.spartacodingclub.demo2.entity.Schedule;
import kr.spartacodingclub.demo2.repository.CommentRepository;
import kr.spartacodingclub.demo2.repository.ScheduleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * create on 2025. 5. 22. create by IntelliJ IDEA.
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
@ExtendWith(MockitoExtension.class)
class ScheduleServiceTest {

//  private ScheduleRepository repository = Mockito.mock(ScheduleRepository.class);
//
//  private ScheduleService scheduleService = new ScheduleService(repository);
  @Mock
  private ScheduleRepository repository;


  @InjectMocks
  private ScheduleService scheduleService;

  @Test
  @DisplayName("저장 성공")
  void saveTest() {
    // given
    String content = "test";
    Schedule schedule = Mockito.mock(Schedule.class);
    BDDMockito.given(schedule.getId()).willReturn(1L);
    given(schedule.getContent()).willReturn(content);
    given(schedule.getCreatedAt()).willReturn(LocalDateTime.now());

    // when
    Mockito.when(repository.save(any())).thenReturn(schedule);

    // then
    ScheduleResponse result = scheduleService.save(content);

    Assertions.assertThat(result).isNotNull();
    assertThat(result.getContent()).isEqualTo(content);
  }

  @Test
  void findById() {
    // given
    String content = "test";
    Schedule schedule = Mockito.mock(Schedule.class);
    BDDMockito.given(schedule.getId()).willReturn(1L);
    given(schedule.getContent()).willReturn(content);
    given(schedule.getCreatedAt()).willReturn(LocalDateTime.now());


    // when
//    when(repository.findById(any())).thenReturn(Optional.of(schedule));
    when(repository.findScheduleById(any())).thenReturn(schedule);

    // then
    ScheduleResponse result = scheduleService.findById(1L);
    assertThat(result).isNotNull();
    assertThat(result.getContent()).isEqualTo(content);
  }

  @Test
  void findAll() {
  }

  @Test
  void deleteById() {
    assertDoesNotThrow(() -> scheduleService.deleteById(1L));
  }

  @Test
  void deleteByIdError() {
//    assertDoesNotThrow(() -> scheduleService.deleteById(1L));

    when(repository.findScheduleById(any())).thenThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> scheduleService.deleteById(1L));
  }

  @Test
  void update() {
  }
}