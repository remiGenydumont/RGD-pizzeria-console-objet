package fr.pizza.dao;
import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	/**
	 * Return all pizza contain into storage
	 * @return pizza list
	 */
	List<Pizza> findAllPizzas();
	
	/**
	 * Save a new pizza in the storage
	 * @param pizza the pizza to save
	 */
	void saveNewPizza(Pizza pizza);
	
	/**
	 * Update an existing pizza in the storage
	 * @param codePizza the code to find the pizza to update
	 * @param pizza pizza object to update
	 */
	void updatePizza(String codePizza, Pizza pizza);
	
	/**
	 * Delete an existing pizza from the storage
	 * @param codePizza pizza code to delete
	 */
	void deletePizza(String codePizza);
	
	/**
	 * Find an existing pizza in the storage by the pizza code
	 * @param codePizza the pizza code to find
	 * @return pizza object find
	 */
	Pizza findPizzaByCode(String codePizza);
	
	/**
	 * return a boolean if the pizza exist in the storage
	 * @param codePizza
	 * @return boolean value
	 */
	boolean pizzaExists(String codePizza);
}
