package fr.pizza.services;

public class MenuServicesFactory {
	
	/**
	 * Instancie the right service by the user action
	 * @param action -  the action that user wanting to do 
	 * @return menuService - an intance of MenuService, can be : ListerPizzasService, AjouterPizzaService, ModifierPizzaService.
	 */
	public MenuService getAppropriateServices(int action){
		MenuService menuService = null ;
		switch (action) {
		case 1:
			menuService  = new ListerPizzasService();
			break;
		case 2:
			menuService  = new AjouterPizzaService();
			break;
		case 3:
			menuService  = new ModifierPizzaService();
			break;
		case 4:
			menuService  = new SupprimerPizzaService();
			break;
		}
		return menuService ;
	}
}
