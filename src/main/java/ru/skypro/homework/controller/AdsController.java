package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ad;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
@Tag(name = "Объявления")
public class AdsController {

    @GetMapping
    @Operation(summary = "Получение всех объявлений")
    @ApiResponse(responseCode = "200", description = "OK")
    public Ads getAllAds() {
        Ads ads = new Ads();
        ads.setCount(0);
        return ads;
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавление объявления")
    @ApiResponse(responseCode = "201", description = "Created")
    public Ad addAd(@RequestPart("properties") CreateOrUpdateAd props,
                    @RequestPart("image") MultipartFile image) {
        Ad ad = new Ad();
        ad.setPk(1);
        ad.setTitle(props.getTitle());
        ad.setPrice(props.getPrice());
        return ad;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение информации об объявлении")
    @ApiResponse(responseCode = "200", description = "OK")
    public ExtendedAd getAds(@PathVariable Integer id) {
        return new ExtendedAd();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление объявления")
    @ApiResponse(responseCode = "204", description = "No Content")
    public void removeAd(@PathVariable Integer id) { }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление информации об объявлении")
    @ApiResponse(responseCode = "200", description = "OK")
    public Ad updateAds(@PathVariable Integer id, @RequestBody CreateOrUpdateAd req) {
        Ad ad = new Ad();
        ad.setPk(id);
        ad.setTitle(req.getTitle());
        ad.setPrice(req.getPrice());
        return ad;
    }

    @GetMapping("/me")
    @Operation(summary = "Получение объявлений авторизованного пользователя")
    @ApiResponse(responseCode = "200", description = "OK")
    public Ads getAdsMe() {
        Ads ads = new Ads();
        ads.setCount(0);
        return ads;
    }

    @PatchMapping(path = "/{id}/image", consumes = "multipart/form-data", produces = "application/octet-stream")
    @Operation(summary = "Обновление картинки объявления")
    @ApiResponse(responseCode = "200", description = "OK")
    public byte[] updateImage(@PathVariable Integer id, @RequestPart("image") MultipartFile image) {
        return new byte[0];
    }
}

