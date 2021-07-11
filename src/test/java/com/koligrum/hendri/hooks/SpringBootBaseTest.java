package com.koligrum.hendri.hooks;

import com.koligrum.hendri.Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class)
public class SpringBootBaseTest {

}
