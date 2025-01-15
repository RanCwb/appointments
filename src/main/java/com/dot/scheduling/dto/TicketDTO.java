package com.dot.scheduling.dto;

public class TicketDTO {
    private Long personId;
    private String title;
    private String description;


    public TicketDTO() {}

    public TicketDTO(Long personId, String title, String description) {
        this.personId = personId;
        this.title = title;
        this.description = description;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
}
