package com.polarbooksshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book (

    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern( //해당 필드는 주어진 정규 표현식의 값과 일치하는 형식을 가져야만 한다.
            regexp = "^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid."
    )
    String isbn,

    @NotBlank( //널값이 되어서는 안되며 , 화이트 스페이스가 아닌 하나의 문자 이상을 가져야 함
            message = "The book title must be defined."
    )
    String title,

    @NotBlank(message = "The book author must be defined.")
    String author,

    @NotNull(message = "The book price must be defined.")
    @Positive( //이 필드는 널값이 안되어야 하며 0보다 커야 함
            message = "The book price must be greater than zero."
    )
    Double price
    
) {

}

