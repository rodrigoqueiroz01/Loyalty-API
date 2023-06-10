package com.rq.loyalty.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CustomerRequestDTO {

    @CPF(message = "Enter only the CPF numbers.")
    @NotBlank(message = "Document field is mandatory.")
    @Length(min = 11, max = 11, message = "Please respect the 11 character limit.")
    private String document;

    @NotBlank(message = "Name field is mandatory.")
    private String name;

}
