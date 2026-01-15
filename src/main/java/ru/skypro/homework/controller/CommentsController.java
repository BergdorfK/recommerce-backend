package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;

@RestController
@RequiredArgsConstructor
@Tag(name = "Комментарии")
public class CommentsController {

    @GetMapping("/ads/{id}/comments")
    @Operation(summary = "Получение комментариев объявления")
    @ApiResponse(responseCode = "200", description = "OK")
    public Comments getComments(@PathVariable Integer id) {
        Comments c = new Comments();
        c.setCount(0);
        return c;
    }

    @PostMapping("/ads/{id}/comments")
    @Operation(summary = "Добавление комментария к объявлению")
    @ApiResponse(responseCode = "200", description = "OK")
    public Comment addComment(@PathVariable Integer id, @RequestBody CreateOrUpdateComment req) {
        Comment c = new Comment();
        c.setPk(1);
        c.setText(req.getText());
        return c;
    }

    @DeleteMapping("/ads/{adId}/comments/{commentId}")
    @Operation(summary = "Удаление комментария")
    @ApiResponse(responseCode = "200", description = "OK") // в YAML именно 200
    public void deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) { }

    @PatchMapping("/ads/{adId}/comments/{commentId}")
    @Operation(summary = "Обновление комментария")
    @ApiResponse(responseCode = "200", description = "OK")
    public Comment updateComment(@PathVariable Integer adId,
                                 @PathVariable Integer commentId,
                                 @RequestBody CreateOrUpdateComment req) {
        Comment c = new Comment();
        c.setPk(commentId);
        c.setText(req.getText());
        return c;
    }
}

