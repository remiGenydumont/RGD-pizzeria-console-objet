package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class StringUtils {
	/**
	 * Static function to build a string from a object having field with @ToString tag.
	 * @param obj object containing field to build the string.
	 * @return string representing the object
	 */
	public static String generatePizzaString(Object obj) {
		String displayString = "";
		try {
			for (Field f : obj.getClass().getDeclaredFields()){
				if (f.isAnnotationPresent(ToString.class)){
					ToString annot = f.getAnnotation(ToString.class);
					if (annot.upperCase()) {
						displayString += annot.before()+f.get(obj).toString().toUpperCase()+annot.after()+annot.separator() ;
					}else{
						displayString += annot.before()+f.get(obj).toString()+annot.after()+annot.separator() ;
					}
				} 
			}
		}catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return displayString;
	}
	
}
