package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.StockageException;

public class Validator {	

	/**
	 * Check if an object respect the rules define in their field with @Rules tag
	 * @param obj object to check
	 * @throws StockageException exception trigger when rules aren't respected
	 */
	public static void checkObject(Object obj) throws StockageException{

		try {
			for (Field f : obj.getClass().getDeclaredFields()){
				if (f.isAnnotationPresent(Rules.class)){
					Rules annot = f.getAnnotation(Rules.class);
					
					if( f.getDouble(obj) <= annot.min()){
						throw new StockageException(f.getName()+" cant be under "+annot.min());
					}
				}

			} 
		}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
