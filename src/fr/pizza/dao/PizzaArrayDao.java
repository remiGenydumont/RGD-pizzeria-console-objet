package fr.pizza.dao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.model.CategoryPizza;
import fr.pizzeria.model.Pizza;

public class PizzaArrayDao implements IPizzaDao{

	private ArrayList<Pizza> pizzaList;
	
	public PizzaArrayDao() {
		Pizza[] pizzaArray = {
				new Pizza(0,"PEP", "Pépéroni", 12.50, CategoryPizza.VIANDE),
				new Pizza(1,"MAR", "Margherita", 14.00, CategoryPizza.SANS_VIANDE), 
				new Pizza(2,"REIN", "La Reine", 11.50, CategoryPizza.VIANDE),
				new Pizza(3,"FRO", "La 4 fromages", 12.00,CategoryPizza.SANS_VIANDE),
				new Pizza(4,"CAN", "La cannibale", 12.50, CategoryPizza.VIANDE),
				new Pizza(5,"SAV", "La savoyarde", 13.00, CategoryPizza.VIANDE),
				new Pizza(6,"ORI", "L’orientale", 13.50, CategoryPizza.VIANDE),
				new Pizza(7,"IND", "L’indienne", 14.00, CategoryPizza.VIANDE)
		};
		
		 pizzaList = new ArrayList<Pizza>(Arrays.asList(pizzaArray));
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		return this.pizzaList;
	}
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		this.pizzaList.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza pizzaToUpdate = this.findPizzaByCode(codePizza);
		pizzaToUpdate.libelle = pizza.libelle ;
		pizzaToUpdate.prix = pizza.prix ;
		pizzaToUpdate.code = pizza.code ;
	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza pizzaToDelete = this.findPizzaByCode(codePizza);
		
		this.pizzaList.remove(pizzaToDelete);
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = null ;

		for(int i=0; i<pizzaList.size(); i++){
			if (pizzaList.get(i).code.equals(codePizza)){
				pizzaFind = pizzaList.get(i);
			}
		}
		return pizzaFind;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false ;

		for(int i=0; i<this.pizzaList.size(); i++){
			if (this.pizzaList.get(i).code.equals(codePizza)){
				exist = true ;
			}
		}
		return exist;
	}
	
	public String toString() {
		String content = "" ;
		for(int i=0; i<this.pizzaList.size();i++){
			content += this.pizzaList.get(i).toString() + System.getProperty("line.separator");
		}
		return content;
	}
}
