INSERT INTO Users (user_id, firstname, lastname) values (1, 'Adil', 'Oozeerally');
INSERT INTO Users (user_id, firstname, lastname) values (2, 'Adonay', 'Ghebremedhin');
INSERT INTO Users (user_id, firstname, lastname) values (3, 'Ahmed', 'Osman');

INSERT INTO Recipes (recipe_id, author, cuisine, ingredients, recipename, vegan) values (3, 'Doof Nagev', 'Ethiopian', 'Tomatoes, Onion, Peppers', 'Flower Power', 'True');
INSERT INTO Recipes (recipe_id, author, cuisine, ingredients, recipename, vegan) values (2, 'Roy McDonald', 'Italian', 'Fish, Tomatoes, Rice, Peppers', 'Fish Rougaille', 'False');
INSERT INTO Recipes (recipe_id, author, cuisine, ingredients, recipename, vegan) values (1, 'Bob Hanson', 'Mauritian', 'Chicken, Rice, Potatoes, Eggs', 'Chicken Biryani', 'False');

INSERT INTO rating (ratingid, comment, rating, recipe_id, user_id) values (3, 'If you love nature, grass, the blue sky and the sound of the ocean then you will love this vegan dish!', '5', 3, 2);
INSERT INTO rating (ratingid, comment, rating, recipe_id, user_id) values (2, 'The biryani came out fairly well, the main issue was the size of my utensils for the required ingredients', '3', 1, 3);
INSERT INTO rating (ratingid, comment, rating, recipe_id, user_id) values (1, 'The fish really came alive with the seasoning and the rougaille sauce had a smooth yet firm consistency, the perfect recipe!', '5', 2, 1);

INSERT INTO savedRecipes (user_id, recipe_id) values ('1', '1');
INSERT INTO savedRecipes (user_id, recipe_id) values ('1', '2');
INSERT INTO savedRecipes (user_id, recipe_id) values ('1', '3');
INSERT INTO savedRecipes (user_id, recipe_id) values ('2', '1');
INSERT INTO savedRecipes (user_id, recipe_id) values ('2', '2');
INSERT INTO savedRecipes (user_id, recipe_id) values ('3', '1');

