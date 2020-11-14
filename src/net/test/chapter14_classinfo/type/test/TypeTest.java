package net.test.chapter14_classinfo.type.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.junit.Test;

import net.test.chapter14_classinfo.type.GenericArrayBean;
import net.test.chapter14_classinfo.type.GericObj;
import net.test.chapter14_classinfo.type.ParameterizedTypeBean;
import net.test.chapter14_classinfo.type.TypeVariableBean;
import net.test.chapter14_classinfo.type.WildcardTypeBean;

public class TypeTest {
	public void getClassTypeParameter(Class clz) {
        TypeVariable<Class>[] typeParameters = clz.getTypeParameters();
        if (typeParameters != null) {
            for (TypeVariable<Class> typeParameter : typeParameters) {
                System.out.println(typeParameter);
            }
        }
    }

    public void getClassFields(Class clz) {
        Field[] declaredFields = clz.getDeclaredFields();
        if (declaredFields != null) {
            for (Field declaredField : declaredFields) {
                Type genericType = declaredField.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType)genericType;
                    Type rawType = parameterizedType.getRawType();
                    System.out.println(rawType);
                    Type ownerType = parameterizedType.getOwnerType();
                    System.out.println(ownerType);
                    String typeName = parameterizedType.getTypeName();
                    System.out.println(typeName);
                    Class<? extends ParameterizedType> aClass = parameterizedType.getClass();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments != null) {
                        for (Type actualTypeArgument : actualTypeArguments) {
                            System.out.println(actualTypeArgument);
                        }
                    }
                }
            }
        }
    }

    public void getClassMethods(Class clz) {
        Method[] declaredMethods = clz.getDeclaredMethods();
        if (declaredMethods != null) {
            for (Method declaredMethod : declaredMethods) {
                Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
                if (genericParameterTypes != null) {
                    for (Type genericParameterType : genericParameterTypes) {
                        System.out.println(genericParameterType);
                    }
                }

                TypeVariable<Method>[] typeParameters1 = declaredMethod.getTypeParameters();
                if (typeParameters1 != null) {
                    for (TypeVariable typeVariable : typeParameters1) {
                        System.out.println(typeVariable);
                    }
                }

                Class<?> returnType = declaredMethod.getReturnType();
                Type genericReturnType = declaredMethod.getGenericReturnType();
                System.out.println(genericReturnType);
            }
        }
    }
    
    @Test
    public void testGetClassMethods() {
        GericObj<Integer> gericObj = new GericObj<>();
        getClassMethods(gericObj.getClass());
    }
    
    @Test
	public void testParameterizedType() {
		ParameterizedTypeBean.printParameterizedType();
	}
    
    @Test
    public void testTypeVariable() {
    	TypeVariableBean.printTypeVariable();
    }
    
    @Test
    public void testGenericArrayType() {
    	GenericArrayBean.printGenericArray();
    }
    
    @Test
    public void testWildcardType() {
    	WildcardTypeBean.printWildcardType();
    }
}
