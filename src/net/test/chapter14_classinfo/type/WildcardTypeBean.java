package net.test.chapter14_classinfo.type;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

public class WildcardTypeBean {
	public void action(List<? extends OutputStream> numberList, List<? super InputStream> upperList,
			List<Integer> list, InputStream inputStream) {
		
	}
	
	public static void printWildcardType() {
		Method[] methods = WildcardTypeBean.class.getDeclaredMethods();
		for (Method method : methods) {
			Type[] types = method.getGenericParameterTypes();
			for (Type paraType : types) {
				System.out.println("type: " + paraType.toString());
				
				if (!(paraType instanceof ParameterizedType)) {
					continue;
				}
				
				Type type = ((ParameterizedType)paraType).getActualTypeArguments()[0];
				System.out.println("type instanceof WildcardType: " + (type instanceof WildcardType));
				if (type instanceof WildcardType) {
					int lowindex = ((WildcardType)type).getLowerBounds().length - 1;
					int highindex = ((WildcardType)type).getUpperBounds().length - 1;
					System.out.println("getLowerBounds():" + (lowindex >= 0 ? ((WildcardType)type).getLowerBounds()[lowindex] : "String") 
							+ ";getUpperBounds():"
							+ (highindex >= 0 ? ((WildcardType)type).getUpperBounds()[highindex] : "Object"));
				}
			}
		}
	}
}
