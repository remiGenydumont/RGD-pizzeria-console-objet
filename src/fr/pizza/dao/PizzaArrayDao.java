package fr.pizza.dao;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.model.Pizza;

public class PizzaArrayDao implements IPizzaDao{
	private Pizza[] pizzaList = {
			new Pizza(0,"PEP", "Pépéroni", 12.50),
			new Pizza(1,"MAR", "Margherita", 14.00), 
			new Pizza(2,"REIN", "La Reine", 11.50),
			new Pizza(3,"FRO", "La 4 fromages", 12.00),
			new Pizza(4,"CAN", "La cannibale", 12.50),
			new Pizza(5,"SAV", "La savoyarde", 13.00),
			new Pizza(6,"ORI", "L’orientale", 13.50),
			new Pizza(7,"IND", "L’indienne", 14.00)
	};

	public PizzaArrayDao() {

	}


	@Override
	public Pizza[] findAllPizzas() {
		return this.pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Pizza[] memoryArray = this.pizzaList ;
		this.pizzaList = new Pizza[memoryArray.length+1];
		for(int i=0; i<memoryArray.length;i++){
			pizzaList[i] = memoryArray[i];
		}
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
		Pizza[] tempListPizza = new Pizza[this.pizzaList.length-1];
		int tempCounter =0;
		for(int i=0; i<this.pizzaList.length; i++){
			if(this.pizzaList[i].code != codePizza){
				tempListPizza[tempCounter] = this.pizzaList[i];
				tempCounter++;
			}
		}
		this.pizzaList = tempListPizza;
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = null ;

		for(int i=0; i<pizzaList.length; i++){
			if (pizzaList[i].code.equals(codePizza)){
				pizzaFind = pizzaList[i] ;
			}
		}
		return pizzaFind;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false ;

		for(int i=0; i<pizzaList.length; i++){
			if (pizzaList[i].code.equals(codePizza)){
				exist = true ;
			}
		}
		return exist;
	}
	
	
	public Pizza[] getPizzaList() {
		return pizzaList;
	}

	public void setPizzaList(Pizza[] pizzaList) {
		this.pizzaList = pizzaList;
	}
	

}
