package com.isea533.mybatis.test.ognl;

import java.util.List;

public class Person {

    private String username;
    private String password;
    private Dog dog;
    private List<Cat> cats;

    public static void staticMethod() {
        System.out.println("the static method is invoked");
    }

    public void instanceMethod() {
        System.out.println("the instance method is invoked");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Dog getDog() {
        return dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dog=" + dog +
                '}';
    }

    public Person(String username, String password, Dog dog) {
        this.username = username;
        this.password = password;
        this.dog = dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


}
