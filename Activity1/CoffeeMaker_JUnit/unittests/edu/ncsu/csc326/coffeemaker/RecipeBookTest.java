package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

import java.lang.reflect.Field;

public class RecipeBookTest extends TestCase {

	private RecipeBook recipeBook;
	private Recipe recipe;

	protected void setUp() throws Exception {
		recipeBook = new RecipeBook();
		recipe = new Recipe();
		recipe.setName("test");
		recipe.setPrice("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		recipe.setAmtCoffee("1");
		recipe.setAmtMilk("1");
		super.setUp();
	}

	public Recipe[] getArray(String field){
		Recipe[] result = null;
		try {
			Field afield = RecipeBook.class.getDeclaredField(field);
			afield.setAccessible(true);
			result = (Recipe[]) afield.get(recipeBook);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	//Calvin
	public void testRecipeBook() {
		assertNotNull("RecipeBook not created.", recipeBook);
	}

	//Calvin
	public void testGetRecipes() {
		assertEquals("The getter for RecipeBook is incorrect.",getArray("recipeArray"), recipeBook.getRecipes());
	}

	//Calvin
	public void testAddRecipe() {
		recipeBook.addRecipe(recipe);
		System.out.println(	recipeBook.getRecipes()[0]);
		assertEquals("Recipe cannot be added", recipeBook.getRecipes()[0], recipe);
	}

	public void testAddDupRecipe() {
		recipeBook.addRecipe(recipe);
		recipeBook.addRecipe(recipe);
		for(int i = 1; i < recipeBook.getRecipes().length; i++) {
			if(recipeBook.getRecipes()[i] != null){
				fail("Duplicate recipe was added when it shouldn't have been.");
			}
		}
	}

	public void testAddRecipeToFullBook() {
		recipeBook.addRecipe(recipe);
		recipe.setName("test2");
		recipeBook.addRecipe(recipe);
		recipe.setName("test3");
		recipeBook.addRecipe(recipe);
		recipe.setName("test4");
		recipeBook.addRecipe(recipe);
		for(int i = 1; i < recipeBook.getRecipes().length; i++) {
			if(recipeBook.getRecipes()[i] != null){
				fail("Duplicate recipe was added when it shouldn't have been.");
			}
		}
	}

	//Calvin
	public void testDeleteRecipe() {
		fail("Not yet implemented");
	}

	//Calvin
	public void testEditRecipe() {
		fail("Not yet implemented");
	}

}
