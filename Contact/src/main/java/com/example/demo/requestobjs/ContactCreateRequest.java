package com.example.demo.requestobjs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactCreateRequest {
	@NotNull(message = "Name is required")
    private String name;
	
	@NotNull(message = "Description is required")
    private String description;

    @NotBlank(message = "Header is required")
    private String header;

    @NotBlank(message = "Content is required")
    private String content;

	public ContactCreateRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    
}
