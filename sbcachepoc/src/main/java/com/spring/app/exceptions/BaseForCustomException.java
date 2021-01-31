package com.spring.app.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dell
 */
public class BaseForCustomException extends RuntimeException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CustomExceptionCode code;
    String technicalDescription;
    String userDescription;
    boolean criticalException;
    private Exception exception;

    public BaseForCustomException(CustomExceptionCode code, Exception exception) {
        super(exception);
        this.code = code;
        this.technicalDescription = code.getTechnicalDescription();
        this.userDescription = code.getUserDescription();
        this.criticalException = code.isCriticalException();
        this.exception = exception;
        logException(this);
    }

    private void logException(BaseForCustomException baseForCustomException) {
        logger.info("Exception code : " + baseForCustomException.getCode());
        logger.info("Exception Description : " + baseForCustomException.getTechnicalDescription());
        logger.info("Exception Message : " + baseForCustomException.getMessage());
        logger.info("Exception Cause : " + baseForCustomException.getCause());
    }

    public CustomExceptionCode getCode() {
        return code;
    }

    public void setCode(CustomExceptionCode code) {
        this.code = code;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public boolean isCriticalException() {
        return criticalException;
    }

    public void setCriticalException(boolean criticalException) {
        this.criticalException = criticalException;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
