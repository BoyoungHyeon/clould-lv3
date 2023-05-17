package clouldlv.common;

import clouldlv.CustomerCenterApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerCenterApplication.class })
public class CucumberSpingConfiguration {}
