package fr.pizzeria.console;


import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;
import fr.pizza.services.AjouterPizzaService;
import fr.pizza.services.ListerPizzasService;
import fr.pizza.services.ModifierPizzaService;
import fr.pizza.services.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		PizzaArrayDao pizzaArray = new PizzaArrayDao();
		Scanner userEntry = new Scanner(System.in) ;
		byte action = 0;

		while(action != 99){
			PizzeriaAdminConsoleApp.displayMenu();
			action = userEntry.nextByte();

			switch (action) {
			case 1:
				ListerPizzasService listService = new ListerPizzasService();
				listService.executeUC(pizzaArray, userEntry);
				break;
			case 2:
				AjouterPizzaService ajoutService = new AjouterPizzaService();
				ajoutService.executeUC(pizzaArray, userEntry);
				
				break;
			case 3:
				ModifierPizzaService modifierService = new ModifierPizzaService();
				modifierService.executeUC(pizzaArray, userEntry);
				break;
			case 4:
				SupprimerPizzaService supprimerService = new SupprimerPizzaService();
				supprimerService.executeUC(pizzaArray, userEntry);
				break;
			default:
				break;
			}
		}

		userEntry.close();
	}

	/**
	 * Methode permettant l'affiche du menu dans la console
	 */
	static public void displayMenu(){
		System.out.println("\n");
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
}
