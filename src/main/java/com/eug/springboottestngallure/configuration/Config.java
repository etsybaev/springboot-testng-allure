package com.eug.springboottestngallure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.qameta.allure.springweb.AllureRestTemplate;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

  public static final String PLAIN_REST_TEMPLATE_CLIENT = "plainRestTemplateClient";
  public static final String ALLURE_REST_TEMPLATE = "allureRestTemplate";

  @Bean
  @Primary
  public RestTemplate restTemplate() {
    ClientHttpRequestFactory factory =
        new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    RestTemplate restTemplate = new RestTemplate(factory);

    restTemplate.setInterceptors(
        Arrays.asList(new RequestResponseLoggingInterceptor(), new AllureRestTemplate()));
    return restTemplate;
  }

  //  @Bean(name = PLAIN_REST_TEMPLATE_CLIENT)
  //  public RestTemplate plainRestTemplate(RestTemplateBuilder restTemplateBuilder) {
  //    RestTemplate restTemplate = restTemplateBuilder.build();
  //    restTemplate.setInterceptors(Collections.singletonList(new AllureRestTemplate()));
  //    return restTemplate;
  //  }

  @Bean(name = PLAIN_REST_TEMPLATE_CLIENT)
  public RestTemplate plainRestTemplate() {
    ClientHttpRequestFactory factory =
        new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    RestTemplate restTemplate = new RestTemplate(factory);
    restTemplate.setInterceptors(Collections.singletonList(new AllureRestTemplate()));
    return restTemplate;
  }

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    return objectMapper;
  }
}
