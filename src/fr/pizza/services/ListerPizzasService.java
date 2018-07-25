package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;

public class ListerPizzasService extends MenuService {
	@Override
	public void executeUC(IPizzaDao pizzaArray, Scanner userEntry) {	
		System.out.println(pizzaArray.toString());
	}

}
