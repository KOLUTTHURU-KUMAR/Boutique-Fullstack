package com.boutique.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.entity.Details;
import com.boutique.exception.ResourceNotFoundException;
import com.boutique.repository.BoutiqueRepo;
import com.boutique.service.BoutiqueService;

@Service
public class BoutiqueServiceImpl implements BoutiqueService {
	
	@Autowired
	private BoutiqueRepo boutiquerepo;

	@Override
	public Details saveDetails(Details details) {
		
		Details saveddetails=boutiquerepo.save(details);
		
		 
		return saveddetails; 
	}

	@Override
	public List<Details> getDetails() {
		List<Details> details=boutiquerepo.findAll();
		return details;
	}
	
	@Override
	public void deleteDonation(Long id) 
	{
		boutiquerepo.deleteById(id);
		
	} 
	@Override
	public Details updateDetails(Long id,Details details)
	{
		 Details product = boutiquerepo.findById(id)
			      .orElseThrow(() -> new ResourceNotFoundException("DonationId " + id + "not found"));
				
		product.setName(details.getName());
		product.setQuantity(details.getQuantity());
		product.setAmount(details.getAmount());
		product.setQuality(details.getQuality());
		return boutiquerepo.save(product);
		
	}
	@Override
	 public Details getDetailsById(long id) {
        return boutiquerepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Person with id = " + id));
    }
}
