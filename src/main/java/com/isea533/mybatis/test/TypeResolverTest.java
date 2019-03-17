package com.isea533.mybatis.test;

import org.apache.ibatis.reflection.TypeParameterResolver;

public class TypeResolverTest {

    public static void main(String[] args) {
        TypeParameterResolver.resolveParamTypes()
    }



    public static interface Strategy<T extends MealType> {

        public void doSomething(T t);

    }

    public static class A implements Strategy<MealType> {

        @Override
        public void doSomething(MealType mealType) {

        }
    }


}
