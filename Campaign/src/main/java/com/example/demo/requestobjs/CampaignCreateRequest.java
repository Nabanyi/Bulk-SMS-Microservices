package com.example.demo.requestobjs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignCreateRequest {

    @NotBlank(message = "Message is required")
    private String message;

    @NotBlank(message = "Scheduled is required")
    @Size(max = 15, message = "Scheduled must not exceed 15 characters")
    private String scheduled;

    @NotNull(message = "Scheduled date is required")
    private LocalDateTime scheduledDate;

    @NotNull(message = "Contact ID is required")
    private Integer contact;
    
    @NotBlank(message = "Phone Column is required")
    @Size(max = 100, message = "Phone Column must not exceed 15 characters")
    @JsonProperty("phone_column")
    private String phoneColumn;

    @NotBlank(message = "Status is required")
    @Size(max = 30, message = "Status must not exceed 30 characters")
    private String status;

	public CampaignCreateRequest() {
		super();
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
