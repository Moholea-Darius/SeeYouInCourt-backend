package model;

public class Room {

    private int id;
    private int roomNumber;
    private int maxCapacity;
    private RoomStatus status;
    private int churchId;

    public Room(int id, int roomNumber, int maxCapacity, RoomStatus status, int churchId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.status = status;
        this.churchId = churchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }
}
