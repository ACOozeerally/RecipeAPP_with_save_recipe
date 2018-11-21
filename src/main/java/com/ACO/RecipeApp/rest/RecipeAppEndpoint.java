package com.ACO.RecipeApp.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ACO.RecipeApp.repository.RecipeAppRepository;
import com.ACO.RecipeApp.domain.Recipes;

@Path("/recipeApp")
public class RecipeAppEndpoint {

	@Inject
	private RecipeAppRepository classRepo;

	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return classRepo.getAllUsers();
	}

	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getUser(@PathParam("id") Long userID) {
		return classRepo.getUser(userID);
	}

	@Path("/createaUser")
	@POST
	@Produces({ "application/json" })
	public String createaUser(String user) {
		return classRepo.createUser(user);
	}

	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long userID, String user) {
		{
			return classRepo.updateUser(userID, user);
		}
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long userID) {
		return classRepo.deleteUser(userID);
	}

	public void setService(RecipeAppRepository classRepo) {
		this.classRepo = classRepo;
	}

	// * * * * * * * *//
	// -Recipe Methods-//
	// * * * * * * * *//

	@Path("/getAllRecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return classRepo.getAllRecipes();
	}

	@Path("/getRecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRecipe(@PathParam("id") Long recipeID) {
		return classRepo.getRecipe(recipeID);
	}

	@Path("/createaRecipe")
	@POST
	@Produces({ "application/json" })
	public String createaRecipe(String recipe) {
		return classRepo.createRecipe(recipe);
	}

	@Path("/getAllSavedRecipes/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAllUserSavedRecipes(@PathParam("id") Long userID) {
		return classRepo.getAllUserSavedRecipes(userID);
	}

	@Path("/saveRecipe/{userID}/{recipeID}")
	@POST
	@Produces({ "application/json" })
	public String saveRecipe(@PathParam("recipeID") Long recipeID, @PathParam("userID") Long userID) {
		return classRepo.saveRecipe(recipeID, userID);
	}

	@Path("/updateRecipe/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateRecipe(@PathParam("id") Long recipeID, String recipe) {
		{
			return classRepo.updateRecipe(recipeID, recipe);
		}
	}

	@Path("/removeSavedRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeSavedRecipe(@PathParam("recipeID") Long recipeID) {
		return classRepo.removeSavedRecipe(recipeID);
	}
	
	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRecipe(@PathParam("recipeID") Long recipeID) {
		return classRepo.deleteRecipe(recipeID);
	}
	

	@Path("/deleteRating/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRating(@PathParam("recipeID") Long recipeID) {
		return classRepo.deleteRating(recipeID);
	}
	
	@Path("/getRating/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRating(@PathParam("id") Long recipeID) {
		return classRepo.getRating(recipeID);
	}
	
	@Path("/getAllRatings")
	@GET
	@Produces({ "application/json" })
	public String getAllRatings() {
		return classRepo.getAllRatings();
	}

}