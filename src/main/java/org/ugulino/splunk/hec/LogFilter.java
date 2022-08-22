package org.ugulino.splunk.hec;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.MDC;

import java.util.UUID;

public class LogFilter extends Filter<ILoggingEvent> {
    private static Integer step = 0;
    private static String nextStep() {
        step++;
        return step.toString();
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        MDC.put("step", nextStep());
        MDC.put("flow-id", UUID.randomUUID().toString());
        return FilterReply.NEUTRAL;
    }
}