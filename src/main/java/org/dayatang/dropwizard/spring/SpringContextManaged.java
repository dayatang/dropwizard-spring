package org.dayatang.dropwizard.spring;

import io.dropwizard.lifecycle.Managed;
import org.springframework.context.ConfigurableApplicationContext;


public class SpringContextManaged implements Managed {
  private final ConfigurableApplicationContext context;

  public SpringContextManaged(final ConfigurableApplicationContext context) {
    this.context = context;
  }

  @Override
  public void start() throws Exception {
  }

  @Override
  public void stop() throws Exception {
    context.close();
  }
}
