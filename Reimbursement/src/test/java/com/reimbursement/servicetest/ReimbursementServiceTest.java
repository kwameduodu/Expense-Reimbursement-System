package com.reimbursement.servicetest;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.repository.ReimbursementRepo;
import com.reimbursement.service.ReimbursementService;

public class ReimbursementServiceTest {
	

	//My Object Under Test
	@InjectMocks
	private static ReimbursementService reimbursementService;
	
	//What needs to be mocked? We need to mock the RecipeRepository as we don't want
	//any actual RecipeRepository method invocations when we use our RecipeService.
	@Mock
	private ReimbursementRepo reimbursementRepository;
	
	{
		// We need to initialize our Mockito mocks (or anything that is annotated with
		// Mockito annotations.
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeClass
	public static void setUp() {
		reimbursementService = new ReimbursementService();
	}
	
	/*
	 * The point of unit testing is to isolate defects. In essence, if a test reveals a bug,
	 * I should be able to easily pinpoint where that bug is.
	 * 
	 * This is where Mockito comes in. Mockito allows us to better isolate our tests. It
	 * can prevent method calls to other layers (for instance) or return dummy data/canned responses
	 * when certain methods would be called (this is called "stubbing"). This gives us more control.
	 */
	@Test
	public void testFindAllReimbursement() {
		
		/*
		 * We have to tell Mockito what dummy data should be returned when the 
		 * RecipeRepository's findAll would normally be invoked.
		 * 
		 * It seems reasonable to return a small ArrayList of fake recipes.
		 * 
		 * Essentially, the RecipeRepository's findAll method is NOT going to be called.
		 * This dummy data we've specified below will just be returned instead.
		 */
		
		Mockito.when(reimbursementRepository.findAll()).thenReturn(
				Arrays.asList(
						new Reimbursement(1, "cornbread", "", ""),
						new Reimbursement(2, "lima beans", "",  ""),
						
						new Reimbursement(4, "sardines", "","")
						)
				);
						
		List<Reimbursement> reimburse = reimbursementService.findAll();
		
		Assert.assertEquals("list size should be 3", 3, reimburse.size());
	}
}
