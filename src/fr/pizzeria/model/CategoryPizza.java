package fr.pizzeria.model;

public enum CategoryPizza {
	VIANDE("viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	private String name;

	private CategoryPizza(String name){
		this.name = name;
	}

	public static CategoryPizza getByName(String name){
		for(CategoryPizza c  : CategoryPizza.values()){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
	public String toString(){
		return this.getName();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
