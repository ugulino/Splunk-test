package org.ugulino.splunk.hec;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.ugulino.splunk.hec.LoggerConfiguration.initLoggerConfiguration;

public class SplunkLogback {

    private final static Logger LOGGER = LoggerFactory.getLogger("splunkLogger");
    public static void main(String[] args) throws IOException {
        initLoggerConfiguration();

        LOGGER.info("Iniciando lambda");
        LOGGER.warn("Nome do arquivo com tamanho inválido!");
        LOGGER.error("Falha ao abrir arquivo");
        ObtemProposta service = new ObtemProposta();
        LOGGER.info("Finalizando lambda");
    }
}
