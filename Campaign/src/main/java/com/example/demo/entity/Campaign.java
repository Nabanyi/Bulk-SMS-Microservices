package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "campaign", schema = "sms")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "scheduled", nullable = false, length = 15)
    private String scheduled;

    @Column(name = "scheduled_date", nullable = false)
    private LocalDateTime scheduledDate;

    @Column(name = "contact", nullable = false)
    private Integer contact;

    @Column(name = "userid", nullable = false)
    private Integer userId;

    @Column(name = "status", nullable = false, length = 30)
    private String status;
    
    @Column(name = "phone_column", nullable = false, length = 100)
    private String phoneColumn;

    // Default constructor (required by JPA)
    public Campaign() {}

    public Campaign(Integer id, String message, String scheduled, LocalDateTime scheduledDate, Integer contact,
			Integer userId, String status, String phoneColumn) {
		super();
		this.id = id;
		this.message = message;
		this.scheduled = scheduled;
		this.scheduledDate = scheduledDate;
		this.contact = contact;
		this.userId = userId;
		this.status = status;
		this.phoneColumn = phoneColumn;
	}

	// Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getPhoneColumn() {
		return phoneColumn;
	}

	public void setPhoneColumn(String phoneColumn) {
		this.phoneColumn = phoneColumn;
	}
    
    
}
