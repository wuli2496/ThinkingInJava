package net.test.chapter14_classinfo.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ParameterizedTypeBean {
	private HashMap<String, Object> map;
	private HashSet<String> set;
	private List<String> list;
	private Class<?> clz;
	
	private Integer i;
	private String str;
	
	public static void printParameterizedType() {
		Field[] fields = ParameterizedTypeBean.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println("FieldName: " + f.getName() + " instanceof ParameterizedType is: " + 
								(f.getGenericType() instanceof ParameterizedType));
		}
		getParameterizedTypeWithName("map");
		getParameterizedTypeWithName("str");
	}
	
	public static void getParameterizedTypeWithName(String name) {
		Field f;
		try {
			f = ParameterizedTypeBean.class.getDeclaredField(name);
			f.setAccessible(true);
			Type type = f.getGenericType();
			if (type instanceof ParameterizedType) {
				for (Type param : ((ParameterizedType)type).getActualTypeArguments()) {
					System.out.println("--type actualType---" + param.toString());
				}
				System.out.println("--type ownerType---" + ((ParameterizedType)type).getOwnerType());
				System.out.println("--type rawType--" + ((ParameterizedType)type).getRawType());
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
