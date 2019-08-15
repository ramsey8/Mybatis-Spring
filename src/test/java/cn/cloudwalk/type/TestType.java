package cn.cloudwalk.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestType {

    SubClass<Long> sa = new SubClass<>();

    public static void main(String[] args) throws NoSuchFieldException {

        Type[] types = ((ParameterizedType) (TestType.class.getDeclaredField("sa").getGenericType())).getActualTypeArguments();
        for (Type type : types) {
            System.out.println(type.getTypeName());
        }
    }
}
