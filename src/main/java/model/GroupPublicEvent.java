package model;

public class GroupPublicEvent {
    private int eventId;
    private int groupId;

    public GroupPublicEvent(int eventId, int groupId) {
        this.eventId = eventId;
        this.groupId = groupId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
