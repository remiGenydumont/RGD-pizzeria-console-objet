package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService  {

	@Override
	public void executeUC(IPizzaDao pizzaArray, Scanner userEntry) throws UpdatePizzaException {
		System.out.println(" Mise à jour d’une pizza   :");
		System.out.println(" Veuillez choisir le code de la pizza à modifier.");
		String codeToUpdate = userEntry.next();
		if(!pizzaArray.pizzaExists(codeToUpdate)){
			throw new UpdatePizzaException("Pizza doesn't exist !");
		}
		System.out.println("Veuillez saisir le nouveau code ");
		String code = userEntry.next();
		if(pizzaArray.pizzaExists(codeToUpdate)){
			throw new UpdatePizzaException("Pizza already exist !");
		}
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		String libelle = userEntry.next();
		System.out.println("Veuillez saisir le nouveau prix");
		double prix = Double.parseDouble(userEntry.next());
		Pizza pizzaUpdate = new Pizza(code, libelle, prix);

		pizzaArray.updatePizza(codeToUpdate, pizzaUpdate);
		
	}
}
