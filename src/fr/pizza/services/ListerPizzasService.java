package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	@Override
	public void executeUC(PizzaArrayDao pizzaArray, Scanner userEntry) {
		Pizza[] listPizza = pizzaArray.findAllPizzas();
		System.out.println(" Liste des pizzas  :");
		for(int i=0; i<listPizza.length;i++){
			System.out.println(listPizza[i].id+" - "+listPizza[i].code+" -> "+ listPizza[i].libelle+"("+listPizza[i].prix+"€)");
		}
		System.out.println("\n");
		
	}

}
