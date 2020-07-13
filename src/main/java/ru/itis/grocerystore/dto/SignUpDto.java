package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.grocerystore.models.Role;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    //TODO: add validation
    private String login;
    private String email;
    private String password;
    private Role role;
}
