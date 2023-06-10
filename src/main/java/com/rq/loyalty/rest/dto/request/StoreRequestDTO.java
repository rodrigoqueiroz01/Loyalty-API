package com.rq.loyalty.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class StoreRequestDTO {

    @CNPJ(message = "Enter only the CNPJ numbers.")
    @NotBlank(message = "Document field is mandatory.")
    @Length(min = 14, max = 14, message = "Please respect the 14 character limit.")
    private String document;

    @NotBlank(message = "Name field is mandatory.")
    private String name;

}
