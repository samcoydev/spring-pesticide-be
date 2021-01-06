package com.example.pesticidebe.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "assigned_username")
    private String assignedUsername;

    @Column(name = "creator")
    private String creator;

    @Column(name = "priority_level")
    private int prioritylevel;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "status")
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAssignedUsername() {
        return assignedUsername;
    }

    public void setAssignedUsername(String assignedUsername) {
        this.assignedUsername = assignedUsername;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getPriorityLevel() {
        return prioritylevel;
    }

    public void setPriorityLevel(int prioritylevel) {
        this.prioritylevel = prioritylevel;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", assignedUsername='" + assignedUsername + '\'' +
                ", creator='" + creator + '\'' +
                ", prioritylevel=" + prioritylevel +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }
}
