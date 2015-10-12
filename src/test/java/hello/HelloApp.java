package hello;


import org.dayatang.dropwizard.spring.SpringBundle;
import hello.config.HelloAppConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp extends Application<HelloAppConfiguration> {

    private static final String CONFIGURATION_FILE = "src/test/resources/hello/hello.yml";

    public static void main(String[] args) throws Exception {
        new HelloApp().run(new String[]{"server", CONFIGURATION_FILE});
    }

    @Override
    public void initialize(Bootstrap<HelloAppConfiguration> bootstrap) {
        bootstrap.addBundle(new SpringBundle(applicationContext(), true, true, true));
    }

    @Override
    public void run(HelloAppConfiguration configuration, Environment environment) throws Exception {
        // doing nothing
    }


    private ConfigurableApplicationContext applicationContext() throws BeansException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("hello");
        return context;
    }
}
