import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
		//The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
		//Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
		
		assertSame("error msg", cb2, chromebookList.get(1));
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		//?	Test that Item list is not null
		assertNotNull("Test if there is a valid Chromebook arraylist to retrieve from", chromebookList);
		
		//?	Test that we retrieve info for 2 items if the Item list has 2 items
		assertEquals("test that there will be 2 items being retrieved if Chromebook arraylist has 2 items", 2, chromebookList.size());
		
		//?	Test that the info retrieved from the Item list is the same as the info put in from the ResourceCentre
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);
		
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		//-	Test that an unavailable item cannot be loaned
		cc1.setIsAvailable(false);
		boolean isAvailable = cc1.getIsAvailable();
		boolean isLoanable = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "2021-21-7");
		assertSame("test that we cannot loan out an unavailable item", isAvailable, isLoanable);
		//-	Test that an item becomes unavailable after being loaned
		cc1.setIsAvailable(true);
		ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "2021-21-7");
		assertEquals("test that item is unavailable", false, cc1.getIsAvailable());
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		//-	Test that an unavailable item cannot be loaned
				cb1.setIsAvailable(false);
				boolean isAvailable = cb1.getIsAvailable();
				boolean isLoanable = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "2021-21-7");
				assertSame("test that we cannot loan out an unavailable item", isAvailable, isLoanable);
				//-	Test that an item becomes unavailable after being loaned
				cb1.setIsAvailable(true);
				ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "2021-21-7");
				assertEquals("test that item is unavailable", false, cb1.getIsAvailable());
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
// -	Test that we cannot return an available item (not loaned)
		cc1.setIsAvailable(true);
		boolean isReturnable = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertSame("test that an available item cannot be returned", cc1.getIsAvailable(), isReturnable);
		// -	Test that the item?s availability changes to true after returning
		cc1.setIsAvailable(false);
		boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertEquals("test that the item availability changes back to true after returning", true, isReturned);
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// -	Test that we cannot return an available item (not loaned)
				cb1.setIsAvailable(true);
				boolean isReturnable = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
				assertSame("test that an available item cannot be returned", cb1.getIsAvailable(), isReturnable);
				// -	Test that the item?s availability changes to true after returning
				cb1.setIsAvailable(false);
				boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
				assertEquals("test that the item availability changes back to true after returning", true, isReturned);
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
