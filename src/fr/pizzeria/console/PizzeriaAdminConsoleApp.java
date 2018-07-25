package fr.pizzeria.console;


import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;
import fr.pizza.services.MenuService;
import fr.pizza.services.MenuServicesFactory;

public class PizzeriaAdminConsoleApp {

	/**
	 * Point d'entré du programme
	 * intancie le PizzaArrayDao pour le stockage, le MenuServicesFactory et le scanner pour gérer les entrées utilisateurs et la 
	 * @param args - non utilisé.
	 */
	public static void main(String[] args) {
		PizzaArrayDao pizzaArray = new PizzaArrayDao();
		Scanner userEntry = new Scanner(System.in) ;
		byte action = 0;
		MenuServicesFactory menuServicesFactory =  new MenuServicesFactory();

		while(action != 99){
			PizzeriaAdminConsoleApp.displayMenu();
			action = userEntry.nextByte();
			
			MenuService service = menuServicesFactory.getAppropriateServices(action);
			service.executeUC(pizzaArray, userEntry);
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
