package com.boutique.controller; 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.boutique.entity.Details;
import com.boutique.service.BoutiqueService;
 
@RunWith(SpringRunner.class)
@WebMvcTest(Boutique.class)
public class BoutiqueTest{
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private BoutiqueService weservice;
				 
	@Test
	public void saveDetails() throws Exception
	{
		Details detail = new Details();
		detail.setId(1L);
		detail.setName("T-Shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L); 
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		when(weservice.saveDetails(detail)).thenReturn(detail);
//		mvc.perform(post("/product")
//				.contactType(MediaType.APPLICATION_JSON)
//				.content(new ObjectMapper().writeValuesAsString(contact)))
//		        .andExpect(status().isOk());
		
	} 
	@Test
	public void getDetails() throws Exception
	{
		Details detail = new Details();
		detail.setId(1L);
		detail.setName("T-Shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		
		Details detail1=new Details();
		detail1.setId(2L);
		detail1.setName("badri");
		detail1.setQuantity("2"); 
		detail1.setAmount(230L);
		detail1.setQuality("A2"); 
		detail1.setMandate(LocalDate.of(2015, Month.FEBRUARY, 25));
		detail1.setDiscount(65L);
		
		List<Details> details=new ArrayList<Details>();
		details.add(detail);
		details.add(detail1);
		when(weservice.getDetails()).thenReturn(details);

		mvc.perform(get("/getdetails").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));

	}
	@Test
	public void getProductById()
	{
		Details detail = new Details();
		detail.setId(1L);
		detail.setName("T-Shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		when(weservice.getDetailsById(1)).thenReturn(detail);
	} 
	 
    @Test
    public void deleteById()
    {
    	Details detail = new Details();
		detail.setId(1L);
		detail.setName("T-Shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		doNothing().when(weservice).deleteDonation(1L);
    } 
    @Test 
    public void updateDetails()
    {
    	Details detail = new Details();
		detail.setId(1L);
		detail.setName("T-Shirt");
		detail.setQuantity("1"); 
		detail.setAmount(230L);
		detail.setQuality("A1"); 
		detail.setMandate(LocalDate.of(2015, Month.FEBRUARY, 11));
		detail.setDiscount(765L);
		when(weservice.updateDetails(eq(1L), any(Details.class)))
        .thenReturn(detail); 
 
    } 
	
}

