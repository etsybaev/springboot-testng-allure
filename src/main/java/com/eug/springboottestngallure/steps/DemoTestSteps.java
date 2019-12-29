package com.eug.springboottestngallure.steps;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoTestSteps {


  @Autowired
  private RestTemplate restTemplate;

  @Step
  public String getBodyFromHelloWorldsRestEndpoint(int port){
    return restTemplate.getForObject("http://localhost:" + port + "/", String.class);
  }

  @Step
  public void assertHelloWorldResponse(String actual, String expected){
    assertEquals(actual, expected);
  }


}
