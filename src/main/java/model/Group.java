package model;

public class Group {

    private int id;
    private String name;
    private String description;
    private int churchId;

    public Group(int id, String name, String description, int churchId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.churchId = churchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }
}
