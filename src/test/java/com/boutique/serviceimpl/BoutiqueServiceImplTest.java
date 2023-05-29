package com.boutique.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.boutique.entity.Details;
import com.boutique.repository.BoutiqueRepo;
import com.boutique.service.BoutiqueService; 
@RunWith(SpringRunner.class)
class BoutiqueServiceImplTest {

	@Mock
    private BoutiqueRepo detailRepository;

    @InjectMocks
    private BoutiqueService detailServiceImpl;
    @Before(value = "")
	public void setUp()
	{
		Details detail=new Details();
		detail.setId(1L);
		detail.setName("T-shirt"); 
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		Mockito.when(detailRepository.save(detail)).thenReturn(detail);
		
		Details detail1=new Details();
		detail1.setId(2L);
		detail1.setName("badri");
		detail1.setQuantity("2"); 
		detail1.setAmount(230L);
		detail1.setQuality("A2"); 
		detail1.setMandate(LocalDate.of(2015, Month.FEBRUARY, 25));
		detail1.setDiscount(765L);
		
		List<Details> details=new ArrayList<Details>();
		details.add(detail);
		details.add(detail1);
		Mockito.when(detailRepository.findAll()).thenReturn(details);
			

	}
    @Test
    public void testCreateDetails() {
        // Prepare test data
        Details detail = new Details();
        detail.setId(1L);
		detail.setName("T-shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);

        // Mock BoutiqueRepo behavior
        when(detailRepository.save(detail))
                .thenReturn(detail);

        // Perform the create operation
        Details createdDetails = detailServiceImpl.saveDetails(detail);

        // Verify the created detail matches the input
        assertEquals(detail.getName(), createdDetails.getName());
        assertEquals(detail.getQuantity(), createdDetails.getQuantity());
        assertEquals(detail.getAmount(), createdDetails.getAmount());
        assertEquals(detail.getQuality(), createdDetails.getQuality());
        assertEquals(detail.getMandate(), createdDetails.getMandate());
        assertEquals(detail.getDiscount(), createdDetails.getDiscount());
    }

    @Test
    public void testUpdateDetails() {
        // Prepare test data
        Long detailId = 1L;
        Details details = new Details();
        details.setName("T-shirt");
        details.setQuantity("2");
        details.setAmount(230L);
		details.setQuality("A1"); 
		details.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		details.setDiscount(765L);


        Details existingDetails = new Details();
        existingDetails.setId(detailId);
        existingDetails.setName("Jane Doe");
        existingDetails.setQuantity("2");
        existingDetails.setAmount(230L);
        existingDetails.setQuality("A1");
        existingDetails.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
        existingDetails.setDiscount(765L);
        

        // Mock BoutiqueRepo behavior
        when(detailRepository.findById(detailId))
                .thenReturn(Optional.of(existingDetails));
        when(detailRepository.save(existingDetails))
                .thenReturn(existingDetails);

        // Perform the update operation
        Details result = detailServiceImpl.updateDetails(detailId, details);

        // Verify the result is true
//        assertTrue(result);

        // Verify the detail details were updated correctly
        assertEquals(details.getName(), existingDetails.getName());
        assertEquals(details.getQuantity(), existingDetails.getQuantity());
        assertEquals(details.getAmount(), existingDetails.getAmount());
        assertEquals(details.getQuality(), existingDetails.getQuality());
        assertEquals(details.getMandate(), existingDetails.getMandate());
        assertEquals(details.getDiscount(), existingDetails.getDiscount()); 
    }

    @Test
    public void testDeleteDetails() {
        // Prepare test data
        Long detailId = 1L;

        // Mock BoutiqueRepo behavior
        doNothing().when(detailRepository).deleteById(detailId);

        // Perform the delete operation
//        boolean result = detailServiceImpl.deleteDonation(detailId);

        // Verify the result is true
//        assertTrue(result);

        // Verify the deleteById method was called with the correct parameter
        verify(detailRepository).deleteById(detailId);
    }

    @Test
    public void testGetDetails() {
        // Prepare test data
        Long detailId = 1L;
        Details detail = new Details();
        detail.setId(detailId);
        detail.setName("T-shirt");
        detail.setQuantity("1");
        detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);

        // Mock BoutiqueRepo behavior
        when(detailRepository.findById(detailId))
                .thenReturn(Optional.of(detail));

        // Perform the get operation
        Details result = detailServiceImpl.getDetailsById(detailId);

        // Verify the returned detail matches the input
        assertEquals(detail.getId(), result.getId());
        assertEquals(detail.getName(), result.getName());
        assertEquals(detail.getQuantity(), result.getQuantity());
        assertEquals(detail.getAmount(), result.getAmount());
        assertEquals(detail.getQuality(), result.getQuality());
        assertEquals(detail.getMandate(), result.getMandate());
        assertEquals(detail.getDiscount(), result.getDiscount());
    }
}


