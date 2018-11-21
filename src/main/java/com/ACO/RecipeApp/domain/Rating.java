package com.ACO.RecipeApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ratingID;
	@Column(length = 1)
	private Long rating;
	@Column(length = 255)
	private String comment;
	@Column(name = "user_ID")
	private Long userID;
	@Column(name = "recipe_ID")
	private Long recipeID;

	public Long getRatingID() {
		return ratingID;
	}

	public void setRatingID(Long ratingID) {
		this.ratingID = ratingID;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}

}
