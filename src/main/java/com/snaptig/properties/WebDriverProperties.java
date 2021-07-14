package com.snaptig.properties;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "webdriver")
public class WebDriverProperties {

  private Integer implicitTimeout;
  private Integer explicitTimeout;
  private List<String> chromeArgs;

}
