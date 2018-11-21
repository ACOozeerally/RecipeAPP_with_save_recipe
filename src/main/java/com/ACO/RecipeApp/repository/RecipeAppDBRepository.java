package com.ACO.RecipeApp.repository;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.ACO.RecipeApp.Util.JSONUtil;
import com.ACO.RecipeApp.domain.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ACO.RecipeApp.domain.Rating;
import com.ACO.RecipeApp.domain.Recipes;

@Transactional(SUPPORTS)
@Default
public class RecipeAppDBRepository implements RecipeAppRepository {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public String getAllUsers() {
		TypedQuery<Users> query = manager.createQuery("SELECT a FROM Users a ORDER BY a.userID DESC", Users.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Transactional(REQUIRED)
	@Override
	public String createUser(String user) {
		Users aUser = util.getObjectForJSON(user, Users.class);
		manager.persist(aUser);
		return "{\"message\": \"User sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteUser(Long userID) {
		Users aUser = manager.find(Users.class, userID);
		manager.remove(aUser);
		return "{\"message\": \"User has been sucessfully deleted\"}";
	}

	@Override
	public String getUser(Long userID) {
		Users aUser = manager.find(Users.class, userID);
		return util.getJSONForObject(aUser);
	}

	@Transactional(REQUIRED)
	@Override
	public String updateUser(Long userID, String user) {
		Users aUser = util.getObjectForJSON(user, Users.class);
		Users userInDB = findUser(userID);
		userInDB.setFirstName(aUser.getFirstName());
		userInDB.setLastName(aUser.getLastName());
		return "{\"message\": \"User has been sucessfully updated\"}";
	}

	public Users findUser(Long userID) {
		return manager.find(Users.class, userID);

	}

	public String getAllUserSavedRecipes(Long userID) {
		Users aUser = manager.find(Users.class, userID);
		Collection<Recipes> userSavRecipe = aUser.getSavedRecipes();
		return util.getJSONForObject(userSavRecipe);
	}

	@Transactional(REQUIRED)
	public String saveRecipe(Long recipeID, Long userID) {
		Recipes aRecipe = manager.find(Recipes.class, recipeID);
		Users aUser = manager.find(Users.class, userID);
		List<Recipes> userSavedRecipes = aUser.getSavedRecipes();
		userSavedRecipes.add(aRecipe);
		aUser.setSavedRecipes(userSavedRecipes);
		manager.persist(aUser);
		return util.getJSONForObject(userSavedRecipes);
	}

	// * * \\
	// Recipe Methods \\
	// * * \\

	public String getAllRecipes() {
		Query query = manager.createQuery("Select a FROM Recipes a");
		Collection<Recipes> users = (Collection<Recipes>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)

	public String createRecipe(String recipe) {
		Recipes aRecipe = util.getObjectForJSON(recipe, Recipes.class);
		manager.persist(aRecipe);
		return "{\"message\": \"Recipe sucessfully added\"}";
	}

	public Rating findRating(Long ratingID) {
		return manager.find(Rating.class, ratingID);

	}

	@Transactional(REQUIRED)
	public String deleteRecipe(Long recipeID) {
//		Rating aRating = manager.find(Rating.class, recipeID);
//		manager.remove(aRating);
//		Users aUser = manager.find(Users.class, recipeID);
//		Collection<Recipes> userSavRecipe = aUser.getSavedRecipes();
//		userSavRecipe.removeIf(id -> id.equals(recipeID));
//		
//		Query q = manager.createQuery ("DELETE s FROM savedRecipes s WHERE s.recipe_ID : recipeID");
//		q.setParameter ("recipeID", recipeID);
//		int deleted = q.executeUpdate ();

		Recipes aRecipe = manager.find(Recipes.class, recipeID);
		manager.remove(aRecipe);

		return "{\"message\": \"Recipe sucessfully deleted\"}";
	}

	@Override
	public String getRecipe(Long recipeID) {
		Recipes aRecipe = manager.find(Recipes.class, recipeID);
		return util.getJSONForObject(aRecipe);
	}

	@Transactional(REQUIRED)
	public String updateRecipe(Long recipeID, String recipe) {
		Recipes aRecipe = util.getObjectForJSON(recipe, Recipes.class);
		Recipes recipeInDB = findRecipe(recipeID);
		recipeInDB.setRecipeName(aRecipe.getRecipeName());
		recipeInDB.setIngredients(aRecipe.getIngredients());
		recipeInDB.setCuisine(aRecipe.getCuisine());
		recipeInDB.setVegan(aRecipe.getVegan());
		recipeInDB.setAuthor(aRecipe.getAuthor());
		return "{\"message\": \"Recipe has been sucessfully updated\"}";
	}

	public Recipes findRecipe(Long recipeID) {
		return manager.find(Recipes.class, recipeID);
	}

	@Transactional(REQUIRED)
	public String removeSavedRecipe(Long recipeID) {
//		Users aUser = manager.find(Users.class, userID);
//		Recipes recipeInDB = manager.find(Recipes.class, recipeID);
//		List<Recipes> userSavedRecipes = aUser.getSavedRecipes();
//		userSavedRecipes.remove(userSavedRecipes.indexOf(recipeInDB));
//		aUser.setSavedRecipes(userSavedRecipes);
//		return util.getJSONForObject(userSavedRecipes);
//		TypedQuery<Recipes> query = manager.createQuery("DELETE FROM savedRecipes s WHERE s.RECIPE_ID = recipeID",
//				Recipes.class);
//		return util.getJSONForObject(query.getResultList());
		return null;
	}

	@Transactional(REQUIRED)
	public String deleteRating(Long theRecipeID) {
//		Rating aRating = manager.find(Rating.class, recipeID);
//		manager.remove(aRating);

		Query query = manager.createQuery("DELETE FROM Rating o WHERE o.recipeID=:theRecipeID");
		query.setParameter("theRecipeID", theRecipeID);
		int result = query.executeUpdate();

		return "{\"message\": \"Rating has been sucessfully updated\"}" + result;
	}

	@Override
	public String getRating(Long ratingID) {
		Rating aRating = manager.find(Rating.class, ratingID);
		return util.getJSONForObject(aRating);
	}

	@Override
	public String getAllRatings() {
		TypedQuery<Rating> query = manager.createQuery("SELECT a FROM Rating a ORDER BY a.ratingID DESC", Rating.class);
		return util.getJSONForObject(query.getResultList());
	}

}
