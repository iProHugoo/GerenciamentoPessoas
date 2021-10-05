package com.dio.GerenciamentoPessoas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dio.GerenciamentoPessoas.enums.PhoneType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;
}
