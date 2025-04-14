package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContactGetDTO;
import com.example.demo.requestobjs.ContactCreateRequest;
import com.example.demo.service.ContactService;
import com.example.demo.utils.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contact")
@Tag(name = "Contact", description = "APIs for Contact & Contact Groups")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Get Contacts", description = "Get all user contacts")
    @GetMapping("/get")
    public ApiResponse<List<ContactGetDTO>> getAllContacts() {
		//System.out.println("user Details: "+userId);
        return new ApiResponse<List<ContactGetDTO>> (true, "Data retrieved", contactService.findAll());
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Get Contact", description = "Get single user contact")
    @GetMapping("/single/{contactid}")
    public ApiResponse<ContactGetDTO> getContact(@PathVariable(name = "contactid") Integer contactID) {
        return new ApiResponse<ContactGetDTO> (true, "Data retrieved", contactService.findContact(contactID));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Create Contact", description = "Create user contact")
    @PostMapping("/create")
    public ApiResponse<ContactGetDTO> createContact(@RequestBody ContactCreateRequest request) {
        return new ApiResponse<ContactGetDTO> (true, "Group created successfully", contactService.create(request));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Update Contact", description = "Update user contact")
    @PostMapping("/update/{contactid}")
    public ApiResponse<ContactGetDTO> updateContact(@PathVariable(name = "contactid") Integer contactID, @RequestBody ContactCreateRequest request) {
        return new ApiResponse<ContactGetDTO> (true, "Group created successfully", contactService.update(request, contactID));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Delete Contact", description = "Delete single user contact")
    @GetMapping("/delete/{contactid}")
    public ApiResponse<Void> deleteContact(@PathVariable(name = "contactid") Integer contactID) {
		contactService.deleteContact(contactID);
        return new ApiResponse<Void> (true, "Data retrieved", null);
    }
}
