package com.ACO.RecipeApp.repository;

import com.ACO.RecipeApp.domain.Recipes;
import com.ACO.RecipeApp.domain.Users;

public interface RecipeAppRepository {

	// User Methods
	String getAllUsers();

	String createUser(String user);

	String deleteUser(Long userID);

	String getUser(Long userID);

	String updateUser(Long userID, String user);

	Users findUser(Long userID);

	// User_Save_Recipe Methods
	String getAllUserSavedRecipes(Long userID);

	String saveRecipe(Long recipeID, Long userID);

	String removeSavedRecipe(Long recipeID);

	// Recipe Methods
	String getAllRecipes();

	String createRecipe(String recipe);

	String deleteRecipe(Long recipeID);

	String getRecipe(Long recipeID);

	String updateRecipe(Long recipeID, String user);

	Recipes findRecipe(Long recipeID);
	
	//Rating Methods
	String deleteRating(Long theRecipeID);
	
	String getAllRatings();

	String getRating(Long recipeID);

}
