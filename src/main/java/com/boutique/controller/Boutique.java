package com.boutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.entity.Details;
import com.boutique.service.BoutiqueService;

@RestController
public class Boutique {

	@Autowired
	private BoutiqueService detailsservice;
	
@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping(path = "/product")
	public ResponseEntity<Details> postDetails(@RequestBody Details details) {
		
		return new ResponseEntity<Details>(detailsservice.saveDetails(details), HttpStatus.CREATED);
	}
@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping(path = "/getdetails")
	public ResponseEntity<List<Details>> getAlldetails() {
		return new ResponseEntity<List<Details>>(detailsservice.getDetails(),HttpStatus.OK);
	}	
@CrossOrigin(origins = {"http://localhost:3000"})
@DeleteMapping(path = "/product/{id}")
public ResponseEntity<HttpStatus> deletedonation(@PathVariable("id") long id)
{
    detailsservice.deleteDonation(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
}
@CrossOrigin(origins = {"http://localhost:3000"})
@PutMapping("/product/{id}")
public ResponseEntity<Details> updateDetails(@PathVariable("id") long id, @RequestBody Details details) 
{
    Details updatedPerson = detailsservice.updateDetails(id, details);
    return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
}
@GetMapping("/product/{id}")
public ResponseEntity<Details> getDetailbyId(@PathVariable("id") long id) {
    Details person =detailsservice.getDetailsById(id);
    return new ResponseEntity<>(person, HttpStatus.OK);
}

}
