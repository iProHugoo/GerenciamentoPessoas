package com.dio.GerenciamentoPessoas.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.GerenciamentoPessoas.dto.mapper.PersonMapper;
import com.dio.GerenciamentoPessoas.dto.request.PersonDTO;
import com.dio.GerenciamentoPessoas.dto.response.MessageResponseDTO;
import com.dio.GerenciamentoPessoas.entities.Person;
import com.dio.GerenciamentoPessoas.repositories.PersonRepository;
import com.dio.GerenciamentoPessoas.services.PersonService;

import static com.dio.GerenciamentoPessoas.utils.PersonUtils.createFakeDTO;
import static com.dio.GerenciamentoPessoas.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;

	@Mock
	private PersonMapper personMapper;

	@InjectMocks
	private PersonService personService;

	@Test
	void testGivenPersonDTOThenReturnSuccessSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();

		when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

		MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
		MessageResponseDTO successMessage = personService.create(personDTO);

		assertEquals(expectedSuccessMessage, successMessage);
	}

	private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
		return MessageResponseDTO.builder().message("Person successfully created with ID " + savedPersonId).build();
	}

}
