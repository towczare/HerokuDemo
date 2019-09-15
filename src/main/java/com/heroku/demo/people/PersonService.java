package com.heroku.demo.people;

import com.heroku.demo.avatar.AvatarGenerator;
import com.heroku.demo.upload.UploadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final UploadService uploadService;

    public PersonService(PersonRepository repository, UploadService uploadService) {
        this.repository = repository;
        this.uploadService = uploadService;
    }

    public List<Person> getPeople() {
        return repository.findAll().stream().map(pe -> pe.toPerson()).collect(Collectors.toList());
    }

    public void save(PersonForm personForm) {
        repository.save(PersonEntity.create(personForm.getName(), personForm.getAge(), getImageUrl(personForm)));
    }

    private String getImageUrl(PersonForm personForm) {
        return !personForm.getImage().isEmpty() ?
        uploadService.upload(personForm.getImage()) :
        AvatarGenerator.getAvatar(personForm.getName()+ personForm.getAge());
    }
}
