package model;

public class GroupPrivateEvent {

    private int publicEventId;
    private int groupId;

    public GroupPrivateEvent(int publicEventId, int groupId) {
        this.publicEventId = publicEventId;
        this.groupId = groupId;
    }

    public int getPublicEventId() {
        return publicEventId;
    }

    public void setPublicEventId(int publicEventId) {
        this.publicEventId = publicEventId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
