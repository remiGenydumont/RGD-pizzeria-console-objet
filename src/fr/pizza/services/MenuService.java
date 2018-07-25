package fr.pizza.services;

import java.util.Scanner;
import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class MenuService {
	
	/**
	 * run the user case 
	 * @param pizzaArray - the storage array for pizza
	 * @param userEntry - the scanner allowing to get user keyboard entry 
	 * @throws UpdatePizzaException 
	 * @throws DeletePizzaException 
	 * @throws SavePizzaException 
	 */
	public abstract void executeUC(IPizzaDao pizzaArray, Scanner userEntry) throws UpdatePizzaException, DeletePizzaException, SavePizzaException;

}
