package com.heroku.demo.people;

import javax.persistence.*;

@Entity
@Table(name= "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer age;
    private String imageUrl;

    public static PersonEntity create(String name, Integer age, String imageUrl) {
        PersonEntity entity = new PersonEntity();
        entity.setAge(age);
        entity.setName(name);
        entity.setImageUrl(imageUrl);
        return entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Person toPerson() {
        return new Person(name, age, imageUrl);
    }
}
