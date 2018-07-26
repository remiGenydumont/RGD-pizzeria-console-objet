package fr.pizza.services;

import java.util.Scanner;
import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class MenuService {
	
	/**
	 * run the user case 
	 * @param pizzaArray - the storage array for pizza
	 * @param userEntry - the scanner allowing to get user keyboard entry 
	 * @throws UpdatePizzaException  exception trigger in Update User case
	 * @throws DeletePizzaException exception trigger in delete user case
	 * @throws SavePizzaException  exception trigger in save user case
	 * @throws StockageException  exception trigger in all previous UC
	 */
	public abstract void executeUC(IPizzaDao pizzaArray, Scanner userEntry) throws UpdatePizzaException, DeletePizzaException, SavePizzaException, StockageException;

}
