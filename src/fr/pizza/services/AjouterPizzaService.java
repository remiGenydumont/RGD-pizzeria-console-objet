package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoryPizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaArray, Scanner userEntry) throws SavePizzaException {
		System.out.println("Ajout d’une nouvelle pizza :");
		System.out.println("Veuillez saisir le code :");
		String code = userEntry.next();
		if(pizzaArray.pizzaExists(code)){
			throw new SavePizzaException("Pizza already exist !");
		}
		System.out.println("Veuillez saisir le nom (sans espace):");
		String libelle = userEntry.next();
		if (libelle.contains(" ")) {
			throw new SavePizzaException();
		}
		System.out.println("Veuillez saisir le prix :");
		double prix = Double.parseDouble(userEntry.next());
		
		System.out.print("Veuillez saisir la catégorie : ");
		for(CategoryPizza c  : CategoryPizza.values()){
			System.out.print(c.getCat() +", ");
		}
		System.out.print("\n");
		String categorie = userEntry.next();
		CategoryPizza cat = CategoryPizza.getByName(categorie);
		if (cat == null) {
			throw new SavePizzaException("Pizza category doesn't exist !");
		}

		pizzaArray.saveNewPizza(new Pizza(code, libelle, prix, cat));
	}
}
