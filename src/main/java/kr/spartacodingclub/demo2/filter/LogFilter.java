/*
 * Created by Hochan Son on 2025. 5. 23.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 23.
 */

package kr.spartacodingclub.demo2.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import javax.lang.model.type.ErrorType;
import java.io.IOException;

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
@Slf4j
public class LogFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    String uri = request.getRequestURI();

    log.info(uri);

    if (uri.equals("/login")) {
      exceptionHandler((HttpServletResponse) servletResponse);
      return;
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void exceptionHandler(HttpServletResponse response) {
    response.setStatus(404);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    try {
      String json = new ObjectMapper().writeValueAsString(response);
      response.getWriter().write(json);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}


