package com.heroku.demo.people;

import org.springframework.web.multipart.MultipartFile;

public class PersonForm {
    private String name;
    private Integer age;
    private MultipartFile image;

    public PersonForm() {
    }

    public PersonForm(String name, Integer age, MultipartFile image) {
        this.name = name;
        this.age = age;
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
