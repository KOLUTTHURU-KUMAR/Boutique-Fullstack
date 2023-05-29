package com.boutique.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boutique.entity.Details;

@Service
public interface BoutiqueService {

	public Details saveDetails(Details details);
	
	public List<Details> getDetails();
	
	public void deleteDonation(Long id);
	
	public Details updateDetails(Long id,Details detail);
	
	 public Details getDetailsById(long id);
}
