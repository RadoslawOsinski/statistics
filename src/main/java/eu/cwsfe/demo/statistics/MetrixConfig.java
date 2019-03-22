package eu.cwsfe.demo.statistics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Radosław Osiński
 */
@Configuration
public class MetrixConfig {

    private final Environment environment;

    public MetrixConfig(Environment environment, MeterRegistry registry) {
        this.environment = environment;
        registry.counter("helloController.hello1");
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config()
                .commonTags("region", environment.getProperty("app.region"))
                .commonTags("name", environment.getProperty("app.name"))
                .commonTags("ip", environment.getProperty("app.ip"))
        ;
    }

}
