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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.ACO.RecipeApp.domain.Recipes;

@Entity
public class Users {

	public Users() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_ID")
	private Long userID;
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "savedRecipes", joinColumns = { @JoinColumn(name = "user_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "recipe_ID") })
	List<Recipes> savedRecipes;

	// standard constructor/getters/setters

	public Users(Long userID, String firstName, String lastName, List<Recipes> savedRecipes) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.savedRecipes = savedRecipes;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Recipes> getSavedRecipes() {
		return savedRecipes;
	}

	public void setSavedRecipes(List<Recipes> recipes) {
		this.savedRecipes = recipes;
	}

}
