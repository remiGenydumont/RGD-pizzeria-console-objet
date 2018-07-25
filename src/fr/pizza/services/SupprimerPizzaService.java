package fr.pizza.services;

import java.util.Scanner;
import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaService extends MenuService  {
	@Override
	public void executeUC(IPizzaDao pizzaArray, Scanner userEntry) throws DeletePizzaException {
		System.out.println(" Suppression d’une pizza   :");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codePizzaToDel = userEntry.next();
		if(!pizzaArray.pizzaExists(codePizzaToDel)){
			throw new DeletePizzaException("Pizza doesn't exist !");
		}
		pizzaArray.deletePizza(codePizzaToDel);
	}
}
