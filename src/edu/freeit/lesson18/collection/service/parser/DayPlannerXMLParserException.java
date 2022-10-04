package edu.freeit.lesson18.collection.service.parser;

import edu.freeit.lesson18.collection.service.DayPlannerServiceException;

public class DayPlannerXMLParserException extends DayPlannerServiceException {
    public DayPlannerXMLParserException() {
    }

    public DayPlannerXMLParserException(String message) {
        super(message);
    }

    public DayPlannerXMLParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DayPlannerXMLParserException(Throwable cause) {
        super(cause);
    }
}
