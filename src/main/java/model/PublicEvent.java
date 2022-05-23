package model;

import java.time.LocalDateTime;

public class PublicEvent extends Event {

    private int roomId;

    public PublicEvent(int id, String eventName, LocalDateTime startDate, LocalDateTime endDate, int churchId) {
        super(id, eventName, startDate, endDate, churchId);
    }
}
