package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CampaignGetDto;
import com.example.demo.requestobjs.CampaignCreateRequest;
import com.example.demo.service.CampaignService;
import com.example.demo.utils.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/campaign")
@Tag(name = "Campaigns", description = "APIs for all campaigns")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Get Campaigns", description = "Get all user Campaigns")
    @GetMapping("/get")
    public ApiResponse<List<CampaignGetDto>> getAllCampaigns() {
        return new ApiResponse<List<CampaignGetDto>> (true, "Data retrieved", campaignService.findAll());
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Get Campaign", description = "Get single user Campaign")
    @GetMapping("/single/{campaignid}")
    public ApiResponse<CampaignGetDto> getCampaign(@PathVariable(name = "campaignid") Integer campaignId) {
        return new ApiResponse<CampaignGetDto> (true, "Data retrieved", campaignService.findCampaign(campaignId));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Create Campaign", description = "Create user campaign")
    @PostMapping("/create")
    public ApiResponse<CampaignGetDto> createCampaign(@RequestBody CampaignCreateRequest request) {
        return new ApiResponse<CampaignGetDto> (true, "Campaign created successfully", campaignService.create(request));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Update Campaign", description = "Update user campaign")
    @PostMapping("/update/{campaignid}")
    public ApiResponse<CampaignGetDto> updateCampaign(@PathVariable(name = "campaignid") Integer campaignId, @RequestBody CampaignCreateRequest request) {
        return new ApiResponse<CampaignGetDto> (true, "Group created successfully", campaignService.update(request, campaignId));
    }
	
	//@PreAuthorize("isAuthenticated()")
	@Operation(summary = "Delete Campaign", description = "Delete single user campaign")
    @GetMapping("/delete/{campaignid}")
    public ApiResponse<Void> deleteContact(@PathVariable(name = "campaignid") Integer campaignId) {
		campaignService.deleteCampaign(campaignId);
        return new ApiResponse<Void> (true, "Data deleted", null);
    }
}
