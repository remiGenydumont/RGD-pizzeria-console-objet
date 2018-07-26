package fr.pizzeria.model;
import java.lang.reflect.Field;

import fr.pizzeria.utils.Rules;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {
	static int counterid = 0 ;
	public int id = 0;
	@ToString(upperCase = true, separator = " -> ")
	public String code ;
	@ToString(separator=" ") 
	public String libelle ;
	@ToString(before = "(", after="€)", separator=" - ") 
	@Rules(min = 0)
	public double prix ;
	@ToString
	public CategoryPizza categorie;

	/**
	 * pizza constructor with auto-increment id
	 * @param code pizza code 
	 * @param libelle pizza name
	 * @param prix pizza price
	 * @param categorie pizza category
	 */
	public Pizza(String code, String libelle, double prix, CategoryPizza categorie) {
		super();

		this.id = counterid;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		Pizza.counterid ++ ;
	}

	/**
	 * pizza constructor with given id
	 * @param id pizza id
	 * @param code pizza code 
	 * @param libelle pizza name
	 * @param prix pizza price
	 * @param categorie pizza category
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoryPizza categorie) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		Pizza.counterid ++ ;
	}
	/**
	 * 
	 */
	public String toString(){
		return StringUtils.generatePizzaString(this) ;
	}
}
