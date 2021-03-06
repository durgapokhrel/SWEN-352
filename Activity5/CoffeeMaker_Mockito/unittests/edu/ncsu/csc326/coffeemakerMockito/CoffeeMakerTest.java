package edu.ncsu.csc326.coffeemakerMockito;

import edu.ncsu.csc326.coffeemakerMockito.CoffeeMaker;
import edu.ncsu.csc326.coffeemakerMockito.Recipe;
import edu.ncsu.csc326.coffeemakerMockito.exceptions.InventoryException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
*
* @author Sarah Heckman
*
* Unit tests for CoffeeMaker class.
*/
@RunWith(MockitoJUnitRunner.class)
public class CoffeeMakerTest{

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	@Before
	public void setUp() throws Exception {
	cm = mock(CoffeeMaker.class);

	//Set up for r1
	r1 = mock(Recipe.class);
	//r1.setName("Coffee");
	when(r1.getName()).thenReturn("Coffee");
	r1.setAmtChocolate("0");
	r1.setAmtCoffee("3");
	r1.setAmtMilk("1");
	r1.setAmtSugar("1");
	r1.setPrice("50");

	//Set up for r2
	r2 = mock(Recipe.class);
	r2.setName("Mocha");
	r2.setAmtChocolate("20");
	r2.setAmtCoffee("3");
	r2.setAmtMilk("1");
	r2.setAmtSugar("1");
	r2.setPrice("75");

	//Set up for r3
	r3 = mock(Recipe.class);
	r3.setName("Latte");
	r3.setAmtChocolate("0");
	r3.setAmtCoffee("3");
	r3.setAmtMilk("3");
	r3.setAmtSugar("1");
	r3.setPrice("100");

	//Set up for r4
	r4 = mock(Recipe.class);
	r4.setName("Hot Chocolate");
	r4.setAmtChocolate("4");
	r4.setAmtCoffee("0");
	r4.setAmtMilk("1");
	r4.setAmtSugar("1");
	r4.setPrice("65");
	}

	@Test
	public void testAddInventory() {
		try {
			cm.addInventory("4","7","0","9");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	@Test
	public void testAddInventoryException() throws InventoryException{
		try {
			cm.addInventory("4", "-1", "asdf", "3");
		}
		catch(InventoryException ie){
			fail("InventoryException should be thrown");
		}
	}

	@Test
	public void testMakeCoffee() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}

}
