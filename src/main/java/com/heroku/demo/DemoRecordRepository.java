package com.heroku.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRecordRepository extends JpaRepository<Demo, Long> {
}
