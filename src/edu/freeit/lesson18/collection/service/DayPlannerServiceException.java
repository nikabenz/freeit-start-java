package edu.freeit.lesson18.collection.service;

import java.io.IOException;

public class DayPlannerServiceException extends IOException {
    public DayPlannerServiceException() {
    }

    public DayPlannerServiceException(String message) {
        super(message);
    }

    public DayPlannerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DayPlannerServiceException(Throwable cause) {
        super(cause);
    }
}
