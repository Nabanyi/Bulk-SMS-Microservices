package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ContactGetDTO;
import com.example.demo.utils.ApiResponse;

@Component
public class ContactClientFallback implements ContactClient {
    @Override
    public ApiResponse<List<ContactGetDTO>> getAllContacts() {
        return new ApiResponse<>(false, "Fallback: Contact service unavailable", Collections.emptyList());
    }
}
