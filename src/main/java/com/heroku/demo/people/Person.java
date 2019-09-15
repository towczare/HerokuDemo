package com.heroku.demo.people;

public class Person {
    private String name;
    private Integer age;
    private String imageUrl;

    public Person(String name, Integer age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
