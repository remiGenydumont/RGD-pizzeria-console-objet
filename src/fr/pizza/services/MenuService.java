package fr.pizza.services;

import java.util.Scanner;

import fr.pizza.dao.PizzaArrayDao;

public abstract class MenuService {
	
	abstract void executeUC(PizzaArrayDao pizzaArray, Scanner userEntry);

}
