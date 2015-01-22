package es.axh.snap.config.metrics;

import javax.inject.Inject;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JHipsterHealthIndicatorConfiguration {

    @Inject
    private JavaMailSenderImpl javaMailSender;

    @Bean
    public HealthIndicator mailHealthIndicator() {
        return new JavaMailHealthIndicator(javaMailSender);
    }
}
