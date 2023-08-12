package com.arcone.learning.controller.dto;

import com.arcone.learning.validator.secret.Secret;
import com.arcone.learning.validator.year.MinYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String id;
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Past
    @MinYear
    private LocalDate dateBirth;
    @NotBlank
    private String phoneNumber;
    @Secret
    private String secret;
}
