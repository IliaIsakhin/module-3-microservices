package com.epam.edu.sender.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class NotificationRequest {
    
    private final String userName;
    private final String message;

    @JsonCreator
    public NotificationRequest(@JsonProperty("userName") String userName, @JsonProperty("message") String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }
    
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationRequest that = (NotificationRequest) o;
        return Objects.equals(userName, that.userName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, message);
    }
}
