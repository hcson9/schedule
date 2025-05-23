package kr.spartacodingclub.demo2.controller;/*
 * Created by Hochan Son on 2025. 5. 23.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 23.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.spartacodingclub.demo2.dto.ScheduleRequest;
import kr.spartacodingclub.demo2.dto.ScheduleResponse;
import kr.spartacodingclub.demo2.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * create on 2025. 5. 23. create by IntelliJ IDEA.
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
@WebMvcTest(ScheduleController.class)
class ScheduleControllerTest {

  @MockitoBean
  private ScheduleService scheduleService;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  private String baseUrl = "/schedules";

  @Test
  void createSchedule() throws Exception {
    // given
    String content = "test";
    ScheduleRequest scheduleRequest = new ScheduleRequest(content);
    ScheduleResponse response = new ScheduleResponse(1L, content, LocalDateTime.now());

    // when
    when(scheduleService.save(anyString())).thenReturn(response);

    // then
    mvc.perform(
                    MockMvcRequestBuilders.post(baseUrl)
                            .content(objectMapper.writeValueAsString(scheduleRequest))
                            .contentType(MediaType.APPLICATION_JSON))

            .andExpectAll(status().isCreated(),
                    content().contentType(MediaType.APPLICATION_JSON),
                    jsonPath("$.content").exists(),
                    jsonPath("$.id").value(1));
  }

  @Test
  void findById() throws Exception {
    // given
    Long id = 1L;
    ScheduleResponse response = new ScheduleResponse(id, "test content", LocalDateTime.now());

    // when
    when(scheduleService.findById(anyLong())).thenReturn(response);

    // then
    mvc.perform(get(baseUrl + "/{id}", id))
            .andExpectAll(status().isOk(),
                    content().contentType(MediaType.APPLICATION_JSON),
                    jsonPath("$.content").exists(),
                    jsonPath("$.id").value(1));
  }

  @Test
  void findAll() throws Exception {
    // given
    List<ScheduleResponse> responseList = new ArrayList<>();
    Long id = 1L;
    ScheduleResponse response = new ScheduleResponse(id, "test content", LocalDateTime.now());
    responseList.add(response);

    // when
    when(scheduleService.findAll()).thenReturn(responseList);

    // then
//    mvc.perform(get(baseUrl))
//            .andExpectAll(status().isOk(),
//                    content().contentType(MediaType.APPLICATION_JSON),
//                    jsonPath("$[0].content").exists(),
//                    jsonPath("$[0].id").value(id));
    mvc.perform(get(baseUrl))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].content").exists())
            .andExpect(jsonPath("$[0].id").value(id));
  }

  @Test
  void deleteById() {
  }

  @Test
  void updateById() {
  }
}