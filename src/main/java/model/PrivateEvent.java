package model;

import java.time.LocalDateTime;

public class PrivateEvent extends Event {

    private String location;

    public PrivateEvent(int id, String eventName, LocalDateTime startDate, LocalDateTime endDate, int churchId) {
        super(id, eventName, startDate, endDate, churchId);
    }
}
