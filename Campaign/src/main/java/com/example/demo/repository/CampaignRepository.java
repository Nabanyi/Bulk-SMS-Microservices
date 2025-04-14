package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Campaign;
import java.util.List;


public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

	List<Campaign> findByUserId(Integer userId);
	
	List<Campaign> findByStatus(String status);
	
	@Query("SELECT c FROM Campaign c WHERE c.id = :campId")
	Campaign findCampaign(@Param("campId") Integer campId);
	
	Campaign findByIdAndUserId(Integer id, Integer userId);
}
