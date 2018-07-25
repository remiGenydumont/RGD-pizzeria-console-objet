package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaArrayDao pizzaArray, Scanner userEntry) {
		System.out.println("Ajout d’une nouvelle pizza :");
		System.out.println("Veuillez saisir le code :");
		String code = userEntry.next();
		System.out.println("Veuillez saisir le nom (sans espace) ::");
		String libelle = userEntry.next();
		System.out.println("Veuillez saisir le prix :");
		double prix = Double.parseDouble(userEntry.next());

		pizzaArray.saveNewPizza(new Pizza(code, libelle, prix));
	}
}
