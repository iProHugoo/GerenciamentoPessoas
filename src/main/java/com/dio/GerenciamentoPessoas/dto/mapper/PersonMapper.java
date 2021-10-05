package com.dio.GerenciamentoPessoas.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dio.GerenciamentoPessoas.dto.request.PersonDTO;
import com.dio.GerenciamentoPessoas.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO dto);

	PersonDTO toDTO(Person dto);
}
