package com.ACO.RecipeApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Recipes {
	
	Recipes(){}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "recipe_ID")
	private Long recipeID;
	@Column(length = 100)
	private String recipeName;
	@Column(length = 255)
	private String ingredients;
	@Column(length = 100)
	private String cuisine;
	@Column(length = 100)
	private Boolean vegan;
	@Column(length = 100)
	private String author;


	//	@Column(name = "user_ID")
//	private String userID;
	@JoinColumn(name = "recipe_ID", referencedColumnName = "recipe_ID")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Rating> ratings;

	@ManyToMany(mappedBy = "savedRecipes")
	
	

	public Long getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public Boolean getVegan() {
		return vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
