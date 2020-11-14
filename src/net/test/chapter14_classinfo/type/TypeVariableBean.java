package net.test.chapter14_classinfo.type;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeVariableBean<K extends Number, T> {
	K key;
	
	T value;
	
	public static void printTypeVariable() {
		Type[] types = TypeVariableBean.class.getTypeParameters();
		for (Type type : types) {
			TypeVariable t = (TypeVariable)type;
			int index = t.getBounds().length - 1;
			System.out.println("--getBounds()--" + t.getBounds()[index]);
			System.out.println("--getName()--" + t.getName());
			System.out.println("--getGenericDeclaration()--" + t.getGenericDeclaration());
		}
	}
	
}
