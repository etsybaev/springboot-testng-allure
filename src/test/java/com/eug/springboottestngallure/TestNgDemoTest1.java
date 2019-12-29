package com.eug.springboottestngallure;

import static org.testng.Assert.assertEquals;

import com.eug.springboottestngallure.listener.TestNgListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Listeners(TestNgListener.class)
public class TestNgDemoTest1 extends AbstractTestNGSpringContextTests {

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void greetingShouldReturnDefaultMessage1() throws Exception {
    assertEquals(
        this.restTemplate.getForObject("http://localhost:" + port + "/", String.class),
        "Hello World");
  }

  @Test
  public void simpleTest1() {
    assertEquals(2 * 2, 4, "2x2 should be 4");
  }
}
