package com.dio.GerenciamentoPessoas.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.dio.GerenciamentoPessoas.dto.request.PersonDTO;
import com.dio.GerenciamentoPessoas.entities.Person;

public class PersonUtils {

	private static final String FIRST_NAME = "Hugo";
	private static final String LAST_NAME = "Coelho";
	private static final String CPF_NUMBER = "123.456.789-00";
	private static final long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER).birthDate("02-02-2020")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO())).build();
	}

	public static Person createFakeEntity() {
		return Person.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE).phones(Collections.singletonList(PhoneUtils.createFakeEntity())).build();
	}

}
