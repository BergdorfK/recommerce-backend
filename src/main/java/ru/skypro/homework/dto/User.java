package ru.skypro.homework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Пользователь")
public class User {
    private Integer id;
    @Schema(description = "логин пользователя")
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @Schema(description = "роль пользователя", allowableValues = {"USER", "ADMIN"})
    private String role;
    @Schema(description = "ссылка на аватар пользователя")
    private String image;
}
