package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;

public abstract class MenuService {
	
	/**
	 * run the user case 
	 * @param pizzaArray - the storage array for pizza
	 * @param userEntry - the scanner allowing to get user keyboard entry 
	 */
	public abstract void executeUC(PizzaArrayDao pizzaArray, Scanner userEntry);

}
