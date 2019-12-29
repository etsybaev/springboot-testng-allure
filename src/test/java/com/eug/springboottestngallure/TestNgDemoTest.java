package com.eug.springboottestngallure;

import static com.eug.springboottestngallure.configuration.Config.PLAIN_REST_TEMPLATE_CLIENT;
import static org.testng.Assert.assertEquals;

import com.eug.springboottestngallure.listener.TestNgListener;
import com.eug.springboottestngallure.steps.DemoTestSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Listeners(TestNgListener.class)
public class TestNgDemoTest extends AbstractTestNGSpringContextTests {

  @LocalServerPort private int port;

  @Autowired
  @Qualifier(PLAIN_REST_TEMPLATE_CLIENT)
  private RestTemplate restTemplate;

  @Autowired
  DemoTestSteps demoTestSteps;

  @Test
  public void greetingShouldReturnDefaultMessage() throws Exception {
     assertEquals(
        this.restTemplate.getForObject("http://localhost:" + port + "/", String.class),
        "Hello World");
  }

  @Test
  public void simpleTest() {
    System.out.println("simpleTest to pass");
    assertEquals(2 * 2, 4, "2x2 should be 4");
  }

  @Test
  public void demoTestListenerestWithStepsAndLogsFromRestTemplate(){
    String bodyFromHelloWorldsRestEndpoint = demoTestSteps.getBodyFromHelloWorldsRestEndpoint(port);
    demoTestSteps.assertHelloWorldResponse(bodyFromHelloWorldsRestEndpoint, "Hello World");
  }
}
