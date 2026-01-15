package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "Пользователи")
public class UsersController {

    @PostMapping("/set_password")
    @Operation(summary = "Обновление пароля")
    @ApiResponse(responseCode = "200", description = "OK")
    public void setPassword(@RequestBody NewPassword req) { }

    @GetMapping("/me")
    @Operation(summary = "Получение информации об авторизованном пользователе")
    @ApiResponse(responseCode = "200", description = "OK")
    public User getUser() {
        return new User();
    }

    @PatchMapping("/me")
    @Operation(summary = "Обновление информации об авторизованном пользователе")
    @ApiResponse(responseCode = "200", description = "OK")
    public UpdateUser updateUser(@RequestBody UpdateUser req) {
        return req;
    }

    @PatchMapping(path = "/me/image", consumes = "multipart/form-data")
    @Operation(summary = "Обновление аватара авторизованного пользователя")
    @ApiResponse(responseCode = "200", description = "OK")
    public void updateUserImage(@RequestPart("image") MultipartFile image) { }
}