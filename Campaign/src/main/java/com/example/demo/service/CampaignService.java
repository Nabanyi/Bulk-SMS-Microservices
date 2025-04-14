package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CampaignRepository;
import com.example.demo.requestobjs.CampaignCreateRequest;
import com.example.demo.utils.Helper;
import com.example.demo.dto.CampaignGetDto;
import com.example.demo.dto.ContactGetDTO;
import com.example.demo.entity.Campaign;

@Service
public class CampaignService {
	
	@Autowired
    private CampaignRepository repository;
	@Autowired
	private ContactClient contactClient;
	@Autowired
	private Helper helper;

    public List<CampaignGetDto> findAll() {
    	List<ContactGetDTO> contacts = contactClient.getAllContacts().getResult();
    	Map<Integer, String> contactsMap = contacts.stream().collect(Collectors.toMap(ContactGetDTO::getId, ContactGetDTO::getName));
    	
        List<Campaign> campaigns = repository.findByUserId(helper.getUserId());
        List<CampaignGetDto> resuList = campaigns.stream().map((campaign) -> {
        	CampaignGetDto dto = new CampaignGetDto();
        	BeanUtils.copyProperties(campaign, dto);
        	dto.setContactName(contactsMap.get(campaign.getContact()));
        	//dto.setContactName("Default");
        	return dto;
        }).collect(Collectors.toList());
        
        return resuList;
    }
    
    public CampaignGetDto findCampaign(Integer campaignId) {
        Campaign campaign = repository.findByIdAndUserId(helper.getUserId(), campaignId);
        CampaignGetDto dto = new CampaignGetDto();
    	BeanUtils.copyProperties(campaign, dto);
        return dto;
    }

    public CampaignGetDto create(CampaignCreateRequest request) {
        Campaign campaign = new Campaign();
        campaign.setUserId(helper.getUserId());
        BeanUtils.copyProperties(request, campaign);
        Campaign createdCampaign = repository.save(campaign);
        
        CampaignGetDto dto = new CampaignGetDto();
        BeanUtils.copyProperties(createdCampaign, dto);
        return dto;
    }
    
    public CampaignGetDto update(CampaignCreateRequest request, Integer campaignId) {
    	Campaign campaign = repository.findByIdAndUserId(helper.getUserId(), campaignId);    	
        BeanUtils.copyProperties(request, campaign);
        repository.save(campaign);
        
        CampaignGetDto dto = new CampaignGetDto();
        BeanUtils.copyProperties(campaign, dto);
        return dto;
    }
    
    public void updateStatus(Integer campId, String status) {
    	Campaign campaign = repository.findCampaign(campId);
    	campaign.setStatus(status);
    	repository.save(campaign);
    }
    
    public void deleteCampaign(Integer campaignId) {
        Campaign campaign = repository.findByIdAndUserId(helper.getUserId(), campaignId);
        repository.delete(campaign);
    }
}
