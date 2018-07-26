package fr.pizzeria.model;

public enum CategoryPizza {
	VIANDE("viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	private String cat;
	
	private CategoryPizza(String cat){
		this.cat = cat;
	}

	public static CategoryPizza getByName(String name){
		for(CategoryPizza c  : CategoryPizza.values()){
			if(c.getCat().equals(name)){
				return c;
			}
		}
		return null;
	}
	
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
}
