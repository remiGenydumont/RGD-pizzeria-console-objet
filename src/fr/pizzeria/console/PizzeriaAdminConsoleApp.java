package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizza.dao.IPizzaDao;
import fr.pizza.dao.PizzaArrayDao;
import fr.pizza.dao.PizzaMapDao;
import fr.pizza.services.MenuService;
import fr.pizza.services.MenuServicesFactory;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class PizzeriaAdminConsoleApp {

	/**
	 * Point d'entré du programme
	 * intancie le PizzaArrayDao pour le stockage, le MenuServicesFactory et le scanner pour gérer les entrées utilisateurs et la 
	 * @param args - non utilisé.
	 */
	public static void main(String[] args) {
		IPizzaDao pizzaArray = null;
		Scanner userEntry = new Scanner(System.in) ;
		byte action = 0;
		MenuServicesFactory menuServicesFactory =  new MenuServicesFactory();

		while(action != 1 && action != 2){
			System.out.println("Veuillez choisir un système de stockage :");
			System.out.println("1 - List:");
			System.out.println("2 - Map:");
			action = userEntry.nextByte();
			switch (action) {
			case 1:
				pizzaArray = new PizzaArrayDao();
				break;
			case 2:
				pizzaArray = new PizzaMapDao();
				break;
			default:
				System.out.println("Veuillez entrer un choix valide! (1 ou 2)");
				break;
			}
		}

		while(action != 99){
			
			PizzeriaAdminConsoleApp.displayMenu();
			action = userEntry.nextByte();
			
			if(action == 99){
				System.out.println("Au revoir.");
			}else if(action == 1 || action == 2 || action == 3 || action == 4){
				
				MenuService service = menuServicesFactory.getAppropriateServices(action);
				try {
					service.executeUC(pizzaArray, userEntry);
				} catch (StockageException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
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
