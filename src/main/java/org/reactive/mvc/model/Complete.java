package org.reactive.mvc.model;


import java.util.Date;

public class Complete extends Order {

    protected Date completed;

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }
}
