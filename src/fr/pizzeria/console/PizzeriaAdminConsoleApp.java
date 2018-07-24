package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		//		Pizza[] listPizza = null;
		Pizza[] listPizza = {
				new Pizza(0,"PEP", "Pépéroni", 12.50),
				new Pizza(1,"MAR", "Margherita", 14.00), 
				new Pizza(2,"REIN", "La Reine", 11.50),
				new Pizza(3,"FRO", "La 4 fromages", 12.00),
				new Pizza(4,"CAN", "La cannibale", 12.50),
				new Pizza(5,"SAV", "La savoyarde", 13.00),
				new Pizza(6,"ORI", "L’orientale", 13.50),
				new Pizza(7,"IND", "L’indienne", 14.00)
		};
		byte action = 0;
		Scanner userEntry = new Scanner(System.in) ;

		while(action != 99){
			do{
				PizzeriaAdminConsoleApp.displayMenu();
				action = userEntry.nextByte();
			}
			while(action != 1 && action != 2 && action != 3 && action != 4);{
				switch (action) {
				case 1:
					if(listPizza != null){
						System.out.println(" Liste des pizzas  :");
						for(int i=0; i<listPizza.length;i++){
							System.out.println(listPizza[i].code+" -> "+ listPizza[i].libelle+"("+listPizza[i].prix+"€)");
						}
						System.out.println("\n");
					}else{
						System.out.println("pas de pizza enregistrée");
					}
					break;
				case 2:
					System.out.println("Ajout d’une nouvelle pizza :");
					System.out.println("Veuillez saisir le code :");
					String code = userEntry.next();
					System.out.println("Veuillez saisir le nom (sans espace) ::");
					String libelle = userEntry.next();
					System.out.println("Veuillez saisir le prix :");
					double prix = Double.parseDouble(userEntry.next());

					// on agrandi le tableau et on recopie les données
					Pizza[] memoryArray = listPizza ;
					if(listPizza != null){
						listPizza = new Pizza[memoryArray.length+1];
						for(int i=0; i<memoryArray.length;i++){
							listPizza[i] = memoryArray[i];
						}
					}else{
						listPizza = new Pizza[1];
					}
					listPizza[listPizza.length-1] = new Pizza(code, libelle, prix);

					break;
				case 3:
					System.out.println(" Mise à jour d’une pizza   :");
					System.out.println(" Veuillez choisir le code de la pizza à modifier.");
					code = userEntry.next();
					int indexModify = PizzeriaAdminConsoleApp.searchPizza(listPizza, code);

					System.out.println("Veuillez saisir le nouveau code ");
					code = userEntry.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace)");
					libelle = userEntry.next();
					System.out.println("Veuillez saisir le nouveau prix");
					prix = Double.parseDouble(userEntry.next());

					listPizza[indexModify].libelle = libelle ;
					listPizza[indexModify].prix = prix ;
					listPizza[indexModify].code = code ;

					break;
				case 4:
					System.out.println(" Suppression d’une pizza   :");
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					code = userEntry.next();
					int indexDel = PizzeriaAdminConsoleApp.searchPizza(listPizza, code);
					listPizza[indexDel]=null;										// on supprime la pizza
					Pizza[] tempListPizza = new Pizza[listPizza.length-1];
					int tempCounter =0;
					for(int i=0; i<listPizza.length; i++){							// on recopie le tableau en ignorant les cases null
						if(listPizza[i] != null){
							tempListPizza[tempCounter] = listPizza[i];
							tempCounter++;
						}
					}
					listPizza = tempListPizza;
					break;
				default:
					break;
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

	/**
	 * Cherche et renvoi l'index d'une pizza dans un tableau 
	 * @param pizzaList le tableau de pizza dans lequel on effectue la recherche
	 * @param name Le nom de la pizza recherchée.
	 * @return index 
	 */
	static public int searchPizza(Pizza[] pizzaList, String code){
		int index = 0 ;

		for(int i=0; i<pizzaList.length; i++){
			if (pizzaList[i].code.equals(code)){
				index = i ;
			}
		}
		return index;
	}

}
