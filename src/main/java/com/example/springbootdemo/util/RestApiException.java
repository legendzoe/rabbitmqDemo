package com.example.springbootdemo.util;

public class RestApiException extends RuntimeException {

    private String errorMessage;

    public RestApiException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RestApiException(String message, Object obj) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public RestApiException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }


    public static String convertMessage(String message, Object... objects) {
        if (message.indexOf("{}") > 0) {
            String s = message.replaceAll("\\{\\}", "%s");
            String format = null;
            try {
                format = String.format(s, objects);
            } catch (Exception e) {
                return message;
            }
            return format;
        } else {
            return message;
        }
    }

}
