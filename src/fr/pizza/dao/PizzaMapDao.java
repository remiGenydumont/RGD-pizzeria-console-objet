package fr.pizza.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.CategoryPizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapDao implements IPizzaDao{

	private Map<String, Pizza> pizzaMap;
	
	public PizzaMapDao() {
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
		this.pizzaMap = new TreeMap<String, Pizza>();
		for(int i=0 ; i<pizzaArray.length;i++){
			pizzaMap.put(pizzaArray[i].code, pizzaArray[i]);
		}
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		return  new ArrayList<Pizza>(pizzaMap.values());
	}
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		this.pizzaMap.put(pizza.code, pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		this.pizzaMap.replace(codePizza, pizza);
	}

	@Override
	public void deletePizza(String codePizza) {
		this.pizzaMap.remove(codePizza);
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		return this.pizzaMap.get(codePizza);
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false ;
		
		if (this.pizzaMap.get(codePizza) != null){
				exist = true ;
			}
		return exist;
	}
	
	public String toString() {
		String content = "" ;
 
		for(Map.Entry<String,Pizza> currentPizza : this.pizzaMap.entrySet()) {
			content += currentPizza.getValue().toString() + System.getProperty("line.separator");
			}
		
		return content;
	}
}
