package org.ugulino.splunk.hec;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public final class LoggerConfiguration {
    public static void initLoggerConfiguration() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        context.putProperty("URL", "https://localhost:8088");
        context.putProperty("TOKEN", "9efa853d-1bc3-4939-bd4d-5dde40087fd8");

        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);

        InputStream is = null;
        try {
            is = SplunkLogback.class.getClassLoader().getResource("logback.xml").openStream();
        } catch (
                IOException e) {
            System.err.println("Error configuring resource load" + e);
        }
        try {
            configurator.doConfigure(is);
            MDC.put("correlation-id", UUID.randomUUID().toString());
            MDC.put("app-name", "splunk.lambda.test");
        } catch (Exception e) {
            System.err.println("Error configuring logging framework" + e);
        }
    }
}
