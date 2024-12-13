package com.JavaMiniProject.SchoolManagementSystem.authController;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    @NotBlank(message = "firstname is required")
   @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    private String firstName;

       @NotBlank(message = "lastname is required")
       @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
     private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message="Email Should be valid")
    private String email;

   @NotBlank(message = "Password is required")
   @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{9,}$", message = "Password must be at least 9 characters long")
    private String password;


    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{9,}$", message = "Password must be at least 9 characters long")
    private String confirmPassword;
}