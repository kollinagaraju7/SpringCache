package com.spring.app.controllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

/**
 * @author
 */

public class RestNotificationErrorHandler extends DefaultResponseErrorHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public void handleError(ClientHttpResponse response) throws IOException {
        LOGGER.info("response body in handleError {}", response.getBody());
    }

}
