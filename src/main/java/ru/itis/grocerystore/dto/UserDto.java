package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String login;
    private String email;
    private Role role;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .role(user.getRole())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }
}
