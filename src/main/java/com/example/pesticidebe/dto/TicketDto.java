package com.example.pesticidebe.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TicketDto {

    private long id;

    @NotNull(message="Title cannot be empty")
    private String title;

    @NotNull(message="Description cannot be empty")
    private String description;

    @NotNull(message="Must have a timestamp")
    private Date timestamp;

    private String assignedUsername;

    @NotNull(message="Must have a creator")
    private String creator;

    private int prioritylevel;

    private Date deadline;

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
        return "TicketDto{" +
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