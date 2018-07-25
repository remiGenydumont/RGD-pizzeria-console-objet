package fr.pizzeria.model;

public class Pizza {
	static int counterid = 0 ;
	public int id = 0;
	public String code ;
	public String libelle ;
	public double prix ;
	
	/**
	 * pizza constructor with auto-increment id
	 * @param code 
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix) {
		super();
		
		this.id = counterid;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		Pizza.counterid ++ ;
	}
	
	/**
	 * pizza constructor with given id
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		Pizza.counterid ++ ;
	}

	public String toString(){
		return this.code+" -> "+ this.libelle+"("+this.prix+"€)";
	}


}
