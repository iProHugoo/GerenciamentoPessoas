package com.dio.GerenciamentoPessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.GerenciamentoPessoas.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
