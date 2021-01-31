package com.spring.app.exceptions;

/**
 * @author Dell
 */
public enum CustomExceptionCode {

    SBE_100("SBE-100", "Data not loading", "Something went wrong. Please contact technichal team.", false);

    String exceptionCode;
    String technicalDescription;
    String userDescription;
    boolean criticalException;

    CustomExceptionCode(String exceptionCode, String technicalDescription, String userDescription, boolean criticalException) {
        this.exceptionCode = exceptionCode;
        this.technicalDescription = technicalDescription;
        this.userDescription = userDescription;
        this.criticalException = criticalException;
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
}
