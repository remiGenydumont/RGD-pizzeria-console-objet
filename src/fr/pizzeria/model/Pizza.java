package fr.pizzeria.model;

public class Pizza {
	static int id = 0;
	public String code ;
	public String libelle ;
	public double prix ;
	
	public Pizza(String code, String libelle, double prix) {
		super();
		this.id += 1;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}



}
