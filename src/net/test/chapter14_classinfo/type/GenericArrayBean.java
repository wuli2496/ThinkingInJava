package net.test.chapter14_classinfo.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.List;

public class GenericArrayBean<T> {
	private T[] value;
	
	private List<String>[] list;
	
	private List<String> singleList;
	private T singleValue;
	
	public static void printGenericArray() {
		Field[] fields = GenericArrayBean.class.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println("Field: " + field.getName()
							 + "; instanceof GenericArrayType:"
							 + (field.getGenericType() instanceof GenericArrayType));
			if (field.getGenericType() instanceof GenericArrayType) {
				System.out.println("Field: " + field.getName()
								+ "; getGenericComponentType():" + 
						((GenericArrayType)field.getGenericType()).getGenericComponentType());
			}
		}
	}
}
