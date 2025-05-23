/*
 * Created by Hochan Son on 2025. 5. 23.
 * As part of
 *
 * Copyright (C)  () - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Backend Team <hc.son9@google.com>, 2025. 5. 23.
 */

package kr.spartacodingclub.demo2.config;

import kr.spartacodingclub.demo2.filter.LogFilter;
import kr.spartacodingclub.demo2.filter.LogFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class FilterConfiguration {

  @Bean
  public FilterRegistrationBean loggingFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter());
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }
  @Bean
  public FilterRegistrationBean loggingFilter2() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter2());
    filterRegistrationBean.setOrder(2);
    filterRegistrationBean.addUrlPatterns("/schedules", "/schedules/**");
    return filterRegistrationBean;
  }
}
