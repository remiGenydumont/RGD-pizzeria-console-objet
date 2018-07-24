package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;

public class SupprimerPizzaService extends MenuService  {
	@Override
	public void executeUC(PizzaArrayDao pizzaArray, Scanner userEntry) {
		System.out.println(" Suppression d’une pizza   :");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codePizzaToDel = userEntry.next();
		pizzaArray.deletePizza(codePizzaToDel);
	}
}
