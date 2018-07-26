package fr.pizzeria.model;

public class Pizza {
	static int counterid = 0 ;
	public int id = 0;
	public String code ;
	public String libelle ;
	public double prix ;
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
		return this.code+" -> "+ this.libelle+"("+this.prix+"€) - "+this.categorie;
	}


}
