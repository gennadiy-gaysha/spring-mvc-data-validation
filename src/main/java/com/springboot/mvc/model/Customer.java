package com.springboot.mvc.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String firstName="";

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName="";
}
