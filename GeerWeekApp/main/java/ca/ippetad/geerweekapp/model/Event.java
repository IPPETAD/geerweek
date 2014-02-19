package ca.ippetad.geerweekapp.model;

/**
 * Created by James on 2/9/14.
 */
public class Event {

    public int resource_icon;
    public String name;
    public String time;
    public String description;
    public String location;

    public Event(String name, String description, int resourceID) {
        this.name = name;
        this.description = description;
        this.resource_icon = resourceID;
    }
}
